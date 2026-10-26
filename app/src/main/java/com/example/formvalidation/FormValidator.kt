package com.example.formvalidation

object FormValidator {

    fun kiemTraHoTen(hoTen: String): Boolean {
        return hoTen.trim().length >= 2
    }

    fun kiemTraEmail(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS
            .matcher(email.trim())
            .matches()
    }

    fun kiemTraMatKhau(matKhau: String): Boolean {
        return matKhau.length >= 6
    }

    fun kiemTraSoDienThoai(soDienThoai: String): Boolean {
        return soDienThoai.matches(Regex("^0[0-9]{9}$"))
    }
}