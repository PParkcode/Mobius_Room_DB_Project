package com.mobius.pbl.domain

/**
 * @file TitleValidator.kt
 * @fn TitleValidator
 * @brief UI/외부 요청에서 사용할 `title` 유효성 검증 로직을 제공합니다.
 *
 * AGENTS.md 품질 지표를 고려해, 이 파일은 Android 의존성이 없는 순수 Kotlin으로 작성합니다.
 */
object TitleValidator {
    private const val MAX_TITLE_LENGTH = 50

    /**
     * @brief title이 유효한지 여부를 반환합니다.
     *
     * - 공백/개행만 있는 문자열은 무효
     * - `trim()` 이후 길이가 `MAX_TITLE_LENGTH` 초과면 무효
     *
     * @param rawTitle 입력 raw title
     * @return 유효하면 true, 아니면 false
     * @date 2026-03-23
     * @author GPT-5.4 Nano v1.0
     */
    fun isValid(rawTitle: String?): Boolean {
        val title = rawTitle?.trim().orEmpty()
        if (title.isEmpty()) return false
        return title.length <= MAX_TITLE_LENGTH
    }
}

