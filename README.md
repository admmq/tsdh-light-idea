# tsdh-light for IntelliJ IDEA

A UI theme and editor color scheme modelled on `tsdh-light`, the theme by Tassilo Horn that ships with GNU Emacs.

Requires IntelliJ-based IDEs 2024.2 (build 242) or newer.

## Build

Needs JDK 21. The Gradle wrapper downloads Gradle and the IntelliJ Platform on first use.

```sh
./gradlew runIde        # sandbox IDE with the plugin loaded; pick the theme once in Settings
./gradlew buildPlugin   # build/distributions/tsdh-light-theme-1.0.0.zip + build/colorScheme/tsdh-light.icls
./gradlew verifyPlugin  # JetBrains Plugin Verifier (downloads several IDE builds)
```

- **Full theme:** Settings → Plugins → ⚙ → *Install Plugin from Disk…* → the zip, then pick **tsdh-light** under
  Settings → Appearance & Behavior → Appearance → Theme.
- **Editor colors only:** Settings → Editor → Color Scheme → ⚙ → *Import Scheme…* → `tsdh-light.icls`.

The IDE used by `runIde` is downloaded according to `platformVersion` in `gradle.properties`. To use an IDE
that's already on disk instead, set `platformLocalPath=/path/to/idea` in `~/.gradle/gradle.properties`.

## License

GNU General Public License, version 3 or (at your option) any later version. See [LICENSE](LICENSE).

The colors come from `tsdh-light-theme.el` in GNU Emacs, Copyright (C) 2011-2026 Free Software Foundation,
Inc., which is distributed under the same license.
