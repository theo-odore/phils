# Rollback Strategy & Checkpoint

## Checkpoint Commit
* **Base Commit Hash**: `39ac75e` (feat: share card link with public web reader and deep linking)
* **Date**: October 20, 2026

## Modified Files
* `android/app/src/main/java/com/phils/app/model/Discovery.kt`
* `android/app/src/main/java/com/phils/app/model/SeedData.kt`
* `android/app/src/main/java/com/phils/app/data/api/NetworkModels.kt`
* `android/app/src/main/java/com/phils/app/ui/detail/DetailScreen.kt`
* `server/src/types.ts`
* `server/src/db/discoveriesData.ts`
* `server/src/services/webReader.ts`
* `docker-compose.yml`
* `server/Dockerfile`

## Exact Rollback Commands

To revert code modifications back to the baseline:

```powershell
# Discard working directory changes
git checkout -- android/app/src/main/java/com/phils/app/model/Discovery.kt `
                android/app/src/main/java/com/phils/app/model/SeedData.kt `
                android/app/src/main/java/com/phils/app/data/api/NetworkModels.kt `
                android/app/src/main/java/com/phils/app/ui/detail/DetailScreen.kt `
                server/src/types.ts `
                server/src/db/discoveriesData.ts `
                server/src/services/webReader.ts `
                docker-compose.yml `
                server/Dockerfile

# Rebuild server
npm --prefix server run build

# Rebuild Android unit tests
cd android
.\gradlew.bat testDebugUnitTest
```

To stop and remove the homeserver container:
```bash
ssh homeserver "cd /projects/phils && docker compose down"
```


### PWA Web Client Rollback
To remove the PWA web subproject:
```powershell
Remove-Item -Recurse -Force "D:\projects\phils\web"
git checkout -- package.json
```

### Product Showcase Website Rollback
To remove the product showcase website:
```powershell
Remove-Item -Recurse -Force "D:\projects\phils\website"
Remove-Item -Force "D:\projects\phils\web\public\landing.html"
git checkout -- package.json
```

### Cloudflare Tunnel & Cellular Access Rollback
To revert the Android network client and stop the cloudflare tunnel:
```powershell
# Revert Android NetworkClient
git checkout -- android/app/src/main/java/com/phils/app/data/api/NetworkClient.kt

# Rebuild and reinstall APK
cd android; .\gradlew.bat assembleDebug
adb -s RZCX60GHR8A install -r --user 0 "app\build\outputs\apk\debug\app-debug.apk"

# Stop tunnel on homeserver
ssh homeserver "docker stop phils-tunnel && docker rm phils-tunnel"
```

### Ponytail Over-Engineering Pruning Rollback
* **Commit**: `5837a31`
To revert the ponytail simplifications:
```powershell
git revert 5837a31
npm --prefix server run build
cd android; .\gradlew.bat assembleDebug
```

