# DEVELOPMENT.md
작성일: 2026-03-23
목적: `REQUIREMENTS.md`에 환경(언어/빌드/런타임) 정보가 없어서, 현재 프로젝트의 빌드 설정을 기준으로 개발 환경을 명시합니다.

## 1. 개발 언어/런타임
- 언어: Kotlin `2.0.21`
- JVM 타겟: `11` (Kotlin `jvmTarget = 11`, Java `sourceCompatibility/targetCompatibility = 11`)
- Android SDK
  - `compileSdk`: 35
  - `minSdk`: 26
  - `targetSdk`: 35

## 2. 빌드 도구/플러그인
- Gradle Wrapper: `8.11.1`
- Android Gradle Plugin (AGP): `8.9.1`
- 빌드 스크립트: Kotlin DSL (`*.gradle.kts`)

## 3. 테스트 런타임
- 테스트 러너: `androidx.test.runner.AndroidJUnitRunner`
- 단위 테스트(예상): `junit 4.13.2`
- 계측 테스트(예상): `androidx.test.espresso:espresso-core 3.5.1`

## 4. 현재 포함된 주요 의존성(빌드 파일 기준)
- `androidx.core:core-ktx 1.10.1`
- `androidx.appcompat:appcompat 1.6.1`
- `com.google.android.material:material 1.10.0`
- (Room 관련 의존성은 현재 빌드 파일에 미포함 상태이며, 구현 단계에서 추가 예정)

## 5. 코드 품질/주석 규정(AGENTS.md 준수 방식)
AGENTS.md의 “Doxygen 스타일 주석” 규정을 Android(Kotlin) 코드에 맞추기 위해, KDoc에 아래 태그를 동일하게 포함하여 준수합니다.
- `@file`, `@fn`, `@brief`, `@param`, `@return`, `@date`, `@author`

## 6. 다음 단계에서 결정해야 할 항목
`REQUIREMENTS.md`가 구현 디테일까지 명시하지 않은 항목은 아래 질문으로 확정 후 설계/개발을 진행합니다.
- UI 방식: Compose UI vs XML UI
- 외부 Intent 처리 방식 및 스펙(액션/엑스트라/처리 주체)
