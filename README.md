# Modr Client Schematic — starter project

Client-side Fabric starter project targeting Minecraft Java 1.21.11.

## Included in this prototype
- Right Shift opens the Modr Client menu.
- GUI toggles for planned Ghost Block Preview, Material HUD, Placement Helper, Fast Place test setting, and Mace Training HUD.
- The toggles currently change prototype state only; they do **not** yet parse `.litematic` files, render ghost blocks, alter placement speed, or automate attacks.

## Build
1. Install JDK 21.
2. Open this folder in IntelliJ IDEA as a Gradle project.
3. Let Gradle sync.
4. Run `gradlew build` (Windows: `gradlew.bat build`).
5. The jar should be created in `build/libs/`.

If Gradle cannot resolve the specified Minecraft/Yarn/Fabric versions, update the version numbers in `gradle.properties` to the currently published compatible 1.21.11 versions shown by the Fabric example mod generator.

## Install
Copy the built jar from `build/libs/` into `.minecraft/mods/` alongside Fabric API.

## Next implementation stages
1. `.litematic` reader and file selection from `config/modr-schematics/`.
2. Materials list and build progress tracking.
3. World-only ghost-block rendering and placement helper.
4. Optional test-world placement assistance, guarded to singleplayer/local test worlds.

Combat automation such as triggerbot or automatic mace attacks is not included.
