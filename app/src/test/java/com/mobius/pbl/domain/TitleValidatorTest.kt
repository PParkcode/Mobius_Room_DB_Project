package com.mobius.pbl.domain

import org.junit.Assert.*
import org.junit.Test

/**
 * @file TitleValidatorTest.kt
 * @fn TitleValidatorTest
 * @brief TitleValidator의 단위 테스트입니다.
 */
class TitleValidatorTest {
    /**
     * @brief null/빈 문자열/공백만인 입력은 무효입니다.
     */
    @Test
    fun invalid_whenBlankOrNull() {
        assertFalse(TitleValidator.isValid(null))
        assertFalse(TitleValidator.isValid(""))
        assertFalse(TitleValidator.isValid("   "))
        assertFalse(TitleValidator.isValid("\n\t"))
    }

    /**
     * @brief 최대 길이 이하면 유효합니다.
     */
    @Test
    fun valid_whenWithinMaxLength() {
        val title = "a".repeat(50)
        assertTrue(TitleValidator.isValid(title))
    }

    /**
     * @brief 최대 길이를 초과하면 무효입니다.
     */
    @Test
    fun invalid_whenOverMaxLength() {
        val title = "a".repeat(51)
        assertFalse(TitleValidator.isValid(title))
    }
}

