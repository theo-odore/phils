# ==============================================================================
# Phils Backend API — Production Dockerfile
# Multi-stage lightweight Node 22 Alpine build
# ==============================================================================

# --- Stage 1: Build & compile TypeScript ---
FROM node:22-alpine AS builder

WORKDIR /app

# Install dependencies (cached if package.json hasn't changed)
COPY package*.json ./
RUN npm ci

# Copy source code and build TypeScript to /app/dist
COPY tsconfig.json ./
COPY src/ ./src/
RUN npm run build

# --- Stage 2: Production runtime ---
FROM node:22-alpine AS runner

WORKDIR /app

ENV NODE_ENV=production
ENV PORT=3000

# Install production-only dependencies
COPY package*.json ./
RUN npm ci --only=production && npm cache clean --force

# Copy compiled JavaScript from builder
COPY --from=builder /app/dist ./dist

# Use non-root node user for security
USER node

EXPOSE 3000

# Built-in health check
HEALTHCHECK --interval=30s --timeout=5s --start-period=5s --retries=3 \
  CMD wget --no-verbose --tries=1 --spider http://localhost:3000/health || exit 1

CMD ["node", "dist/index.js"]
