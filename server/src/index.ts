import express, { Request, Response } from 'express';
import cors from 'cors';
import dotenv from 'dotenv';
import { store } from './db/store';
import { renderWebReaderHtml } from './services/webReader';

dotenv.config();

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(express.json());

// Helper to extract or fallback user_id from headers
const getUserId = (req: Request): string => {
  return (req.headers['x-user-id'] as string) || 'default_user';
};

// ----------------------------------------------------
// Health Check
// ----------------------------------------------------
app.get('/health', (_req: Request, res: Response) => {
  res.json({ status: 'ok', product: 'Phils API', version: '1.0' });
});

// ----------------------------------------------------
// GET /api/v1/feed
// ----------------------------------------------------
app.get('/api/v1/feed', async (req: Request, res: Response) => {
  try {
    const userId = getUserId(req);
    const limit = parseInt(req.query.limit as string) || 15;
    const cursor = req.query.cursor as string | undefined;

    const feed = await store.getFeed(userId, limit, cursor);
    res.json({ success: true, data: feed });
  } catch (err: any) {
    console.error('Error fetching feed:', err);
    res.status(500).json({ success: false, error: 'Failed to fetch discovery feed' });
  }
});

// ----------------------------------------------------
// POST /api/v1/feed/generate (On-demand NVIDIA NIM synthesis)
// ----------------------------------------------------
app.post('/api/v1/feed/generate', async (req: Request, res: Response) => {
  try {
    const count = parseInt(req.body.count as string) || 3;
    const items = await store.generateMore(count);
    res.json({ success: true, data: items });
  } catch (err: any) {
    console.error('Error generating infinite discoveries:', err);
    res.status(500).json({ success: false, error: 'Failed to generate discoveries' });
  }
});

// ----------------------------------------------------
// GET /api/v1/discoveries/:id
// ----------------------------------------------------
app.get('/api/v1/discoveries/:id', async (req: Request, res: Response) => {
  try {
    const userId = getUserId(req);
    const discovery = await store.getDiscoveryById(req.params.id, userId);

    if (!discovery) {
      return res.status(404).json({ success: false, error: 'Discovery not found' });
    }

    res.json({ success: true, data: discovery });
  } catch (err: any) {
    console.error('Error fetching discovery:', err);
    res.status(500).json({ success: false, error: 'Failed to fetch discovery details' });
  }
});

// ----------------------------------------------------
// GET /api/v1/search?q=...
// ----------------------------------------------------
app.get('/api/v1/search', async (req: Request, res: Response) => {
  try {
    const query = (req.query.q as string) || '';
    const limit = parseInt(req.query.limit as string) || 20;

    const results = await store.search(query, limit);
    res.json({ success: true, count: results.length, data: results });
  } catch (err: any) {
    console.error('Error searching discoveries:', err);
    res.status(500).json({ success: false, error: 'Search failed' });
  }
});

// ----------------------------------------------------
// GET /api/v1/saved
// ----------------------------------------------------
app.get('/api/v1/saved', async (req: Request, res: Response) => {
  try {
    const userId = getUserId(req);
    const saved = await store.getSavedDiscoveries(userId);
    res.json({ success: true, count: saved.length, data: saved });
  } catch (err: any) {
    console.error('Error getting saved discoveries:', err);
    res.status(500).json({ success: false, error: 'Failed to retrieve saved items' });
  }
});

// ----------------------------------------------------
// POST /api/v1/saved/:id
// ----------------------------------------------------
app.post('/api/v1/saved/:id', async (req: Request, res: Response) => {
  try {
    const userId = getUserId(req);
    const success = await store.saveDiscovery(userId, req.params.id);

    if (!success) {
      return res.status(404).json({ success: false, error: 'Discovery not found to save' });
    }

    res.json({ success: true, message: 'Saved successfully' });
  } catch (err: any) {
    console.error('Error saving discovery:', err);
    res.status(500).json({ success: false, error: 'Failed to save discovery' });
  }
});

// ----------------------------------------------------
// DELETE /api/v1/saved/:id
// ----------------------------------------------------
app.delete('/api/v1/saved/:id', async (req: Request, res: Response) => {
  try {
    const userId = getUserId(req);
    await store.unsaveDiscovery(userId, req.params.id);
    res.json({ success: true, message: 'Unsaved successfully' });
  } catch (err: any) {
    console.error('Error unsaving discovery:', err);
    res.status(500).json({ success: false, error: 'Failed to unsave discovery' });
  }
});

// ----------------------------------------------------
// POST /api/v1/history/view
// ----------------------------------------------------
app.post('/api/v1/history/view', async (req: Request, res: Response) => {
  try {
    const userId = getUserId(req);
    const { discovery_id, duration_ms } = req.body;

    if (!discovery_id) {
      return res.status(400).json({ success: false, error: 'discovery_id is required' });
    }

    await store.recordView(userId, discovery_id, duration_ms || 0);
    res.json({ success: true });
  } catch (err: any) {
    console.error('Error recording view:', err);
    res.status(500).json({ success: false, error: 'Failed to record history' });
  }
});

// ----------------------------------------------------
// GET /api/v1/profile
// ----------------------------------------------------
app.get('/api/v1/profile', async (req: Request, res: Response) => {
  try {
    const userId = getUserId(req);
    const profile = await store.getUserProfile(userId);
    res.json({ success: true, data: profile });
  } catch (err: any) {
    console.error('Error fetching user profile:', err);
    res.status(500).json({ success: false, error: 'Failed to fetch user profile' });
  }
});

// ----------------------------------------------------
// Public Web Reader: GET /d/:id or /discovery/:id
// Enables recipients without the app to read full cards in their browser
// ----------------------------------------------------
app.get(['/d/:id', '/discovery/:id'], async (req: Request, res: Response) => {
  try {
    const id = req.params.id;
    const discovery = await store.getDiscoveryById(id);
    if (!discovery) {
      return res.status(404).send(`
        <!DOCTYPE html>
        <html lang="en">
        <head>
          <meta charset="UTF-8">
          <meta name="viewport" content="width=device-width, initial-scale=1.0">
          <title>Idea Not Found - Phils</title>
          <style>
            body { background: #0B0E14; color: #F0F4F8; font-family: sans-serif; display: flex; align-items: center; justify-content: center; height: 100vh; margin: 0; text-align: center; }
            h1 { font-family: Georgia, serif; font-style: italic; color: #E5A93C; margin-bottom: 12px; }
            p { color: #94A3B8; margin-bottom: 24px; }
            a { color: #0B0E14; background: #E5A93C; padding: 10px 20px; border-radius: 999px; text-decoration: none; font-weight: 600; }
          </style>
        </head>
        <body>
          <div>
            <h1>Idea Not Found</h1>
            <p>The shared philosophy or paradox could not be found.</p>
            <a href="/api/v1/feed">Explore Phils Feed</a>
          </div>
        </body>
        </html>
      `);
    }

    const html = renderWebReaderHtml(discovery);
    res.setHeader('Content-Type', 'text/html; charset=utf-8');
    res.send(html);
  } catch (err: any) {
    console.error('Error rendering web reader:', err);
    res.status(500).send('Internal Server Error');
  }
});

// Start Server
app.listen(PORT, () => {
  console.log(`========================================`);
  console.log(`🏛️  Phils Backend API running on port ${PORT}`);
  console.log(`📍 Feed: http://localhost:${PORT}/api/v1/feed`);
  console.log(`========================================`);
});
