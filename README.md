# Mobius PBL Project - Room Database Data Manager

## 1. 개요 (Overview)
본 프로젝트는 Android 환경에서 **Room Database**를 활용하여 로컬 데이터를 관리하고, 데이터 변경 사항을 UI에 실시간으로 반영하는 애플리케이션입니다.

## 2. 주요 기능 (Key Features)
- **데이터 관리**: 아이템 추가, 삭제, 상태 변경(Toggle Flag)
- **실시간 UI 업데이트**: Room의 변경 사항을 감지하여 UI 자동 갱신
- **외부 연동**: 외부 Intent를 통한 데이터 조작 (추가/삭제/수정)
- **비동기 처리**: UI 응답성 유지를 위한 비동기 DB 작업

## 3. 기술 스택 (Tech Stack)
- **Language**: Kotlin 2.0.21
- **Runtime**: JVM 11 / Android SDK 35 (Min SDK 26)
- **Database**: Room Persistence Library
- **Build System**: Gradle 8.11.1 (Kotlin DSL)
- **UI Framework**: Activity / Compose UI
- **Test**: JUnit (TDD 기반 개발)

## 4. 시스템 아키텍처 (System Architecture)
- **UI Layer**: Activity / Compose UI
- **ViewModel Layer**: 상태 관리 및 데이터 전달
- **Data Layer**: Repository (선택 사항)
- **Persistence Layer**: Room Database (Entity, DAO)

## 5. 개발 가이드라인 (Development Guidelines)
본 프로젝트는 `AGENTS.md`에 정의된 규격에 따라 개발됩니다.
- **TDD (Test-Driven Development)** 준수
- **Doxygen 스타일 주석** 작성 (`@file`, `@fn`, `@brief` 등)
- **코드 품질 지표**: 함수당 80라인 이하, 순환 복잡도 10 이하, 주석율 20% 이상, 라인 커버리지 80% 이상 준수

## 6. 관련 문서
- [REQUIREMENTS.md](REQUIREMENTS.md): 상세 요구사항 명세서
- [AGENTS.md](AGENTS.md): 개발 프로세스 및 품질 표준
- [DEVELOPMENT.md](DEVELOPMENT.md): 상세 개발 환경 설정
