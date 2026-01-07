# JustResponsiveUi

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)


<html>
  <h2 align="center">
    <img src="screenshots/logo.svg" width="150"/>
  </h2>
</html>

JustResponsiveUi is a minimal Android app that demonstrates building adaptive Jetpack Compose UIs
for phones and tablets (portrait and landscape). It includes separate Login and Register flows with
shared domain validation, MVVM ViewModel + StateFlow, and Dagger Hilt dependency injection.

## Overview

- Small, focused codebase that illustrates adaptive Compose layouts, MVVM separation, and
  single-source validation logic for authentication.

## Screenshots

<details>
<summary>Portrait — Mobile phone</summary>

<p align="center">
<img src="screenshots/phone/portrait/Phone_Portrait_Login.png" alt="Phone Portrait Login" width="300" />
<img src="screenshots/phone/portrait/Phone_Portrait_Login_Error.png" alt="Phone Portrait Login Error" width="300" />
</p>

<p align="center">
<img src="screenshots/phone/portrait/Phone_Portrait_Register.png" alt="Phone Portrait Register" width="300" />
<img src="screenshots/phone/portrait/Phone_Portrait_Register_Error.png" alt="Phone Portrait Register Error" width="300" />
</p>

</details>

<details>
<summary>Portrait — Tablet</summary>

<p align="center">
<img src="screenshots/tablet/portrait/Tablet_Portrait_Login.png" alt="Tablet Portrait Login" width="400" />
<img src="screenshots/tablet/portrait/Tablet_Portrait_Login_Error.png" alt="Tablet Portrait Login Error" width="400" />
</p>

<p align="center">
<img src="screenshots/tablet/portrait/Tablet_Portrait_Register.png" alt="Tablet Portrait Register" width="400" />
<img src="screenshots/tablet/portrait/Tablet_Portrait_Register_Error.png" alt="Tablet Portrait Register Error" width="400" />
</p>

</details>

<details>
<summary>Landscape — Mobile phone</summary>

<p align="center">
<img src="screenshots/phone/landscape/Phone_Landscape_Login.png" alt="Phone Landscape Login" width="300" />
<img src="screenshots/phone/landscape/Phone_Landscape_Login_Error.png" alt="Phone Landscape Login Error" width="300" />
</p>

<p align="center">
<img src="screenshots/phone/landscape/Phone_Landscape_Register.png" alt="Phone Landscape Register" width="300" />
<img src="screenshots/phone/landscape/Phone_Landscape_Register_Error.png" alt="Phone Landscape Register Error" width="300" />
</p>

</details>

<details>
<summary>Landscape — Tablet</summary>

<p align="center">
<img src="screenshots/tablet/landscape/Tablet_Landscape_Login.png" alt="Tablet Landscape Login" width="400" />
<img src="screenshots/tablet/landscape/Tablet_Landscape_Login_Error.png" alt="Tablet Landscape Login Error" width="400" />
</p>

<p align="center">
<img src="screenshots/tablet/landscape/Tablet_Landscape_Register.png" alt="Tablet Landscape Register" width="400" />
<img src="screenshots/tablet/landscape/Tablet_Landscape_Register_Error.png" alt="Tablet Landscape Register Error" width="400" />
</p>

</details>

## Architecture

- Pattern: MVVM — `ViewModel` holds UI state and exposes `StateFlow`; composables render state and
  emit events.
- Layers: domain (use-cases), presentation (Compose screens + ViewModels), DI modules.

## Tech Stack

- Kotlin
- Jetpack Compose (Material3)
- Dagger Hilt (DI)
- Navigation3 (compose-compatible)
- Kotlin Coroutines, StateFlow
- Gradle (wrapper)

## Key Locations

- Auth root: `app/src/main/java/com/feevlic/justresponsiveui/auth`
- Screens: `auth/login` and `auth/register`
- Shared domain use-cases: `auth/shared/domain/usecase`
- Navigation entry: `auth/shared/navigation/AuthNavigation.kt`
- Shared state: `auth/shared/presentation/SharedAuthViewModel.kt`

## Build and run

- Prerequisites: Android Studio, Android SDK, emulator or physical device
- Build:

```
./gradlew clean assembleDebug
```

- Install on device/emulator:

```
./gradlew installDebug
```
