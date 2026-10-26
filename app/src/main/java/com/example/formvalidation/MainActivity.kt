package com.example.formvalidation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.formvalidation.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Xu ly nut Dang ky
        binding.btnDangKy.setOnClickListener {
            dangKy_122()
        }

        // Xu ly nut Huy
        binding.btnHuy.setOnClickListener {
            xoaDuLieu_122()
        }
    }

    private fun dangKy_122() {

        // Lay du lieu tu cac o nhap
        val hoTen_122 =
            binding.edtHoTen.text?.toString()?.trim().orEmpty()

        val email_122 =
            binding.edtEmail.text?.toString()?.trim().orEmpty()

        val matKhau_122 =
            binding.edtMatKhau.text?.toString().orEmpty()

        val soDienThoai_122 =
            binding.edtSoDienThoai.text?.toString()?.trim().orEmpty()

        // Xoa cac thong bao loi cu
        binding.tilHoTen.error = null
        binding.tilEmail.error = null
        binding.tilMatKhau.error = null
        binding.tilSoDienThoai.error = null

        // Validate ho ten
        if (!FormValidator.kiemTraHoTen(hoTen_122)) {
            binding.tilHoTen.error =
                "Họ tên phải có ít nhất 2 ký tự"

            binding.edtHoTen.requestFocus()

            Snackbar.make(
                binding.root,
                "Vui lòng kiểm tra họ tên!",
                Snackbar.LENGTH_LONG
            ).show()

            return
        }

        // Validate email
        if (!FormValidator.kiemTraEmail(email_122)) {
            binding.tilEmail.error =
                "Email không đúng định dạng"

            binding.edtEmail.requestFocus()

            Snackbar.make(
                binding.root,
                "Vui lòng nhập email hợp lệ!",
                Snackbar.LENGTH_LONG
            ).show()

            return
        }

        // Validate mat khau
        if (!FormValidator.kiemTraMatKhau(matKhau_122)) {
            binding.tilMatKhau.error =
                "Mật khẩu phải có ít nhất 6 ký tự"

            binding.edtMatKhau.requestFocus()

            Snackbar.make(
                binding.root,
                "Mật khẩu chưa hợp lệ!",
                Snackbar.LENGTH_LONG
            ).show()

            return
        }

        // Validate so dien thoai
        if (!FormValidator.kiemTraSoDienThoai(soDienThoai_122)) {
            binding.tilSoDienThoai.error =
                "Số điện thoại phải gồm 10 chữ số và bắt đầu bằng 0"

            binding.edtSoDienThoai.requestFocus()

            Snackbar.make(
                binding.root,
                "Vui lòng nhập số điện thoại hợp lệ!",
                Snackbar.LENGTH_LONG
            ).show()

            return
        }

        // Tao doi tuong nguoi dung
        val nguoiDung_122 = NguoiDung(
            hoTen = hoTen_122,
            email = email_122,
            matKhau = matKhau_122,
            soDienThoai = soDienThoai_122
        )

        // Thong bao dang ky thanh cong
        Snackbar.make(
            binding.root,
            "Đăng ký thành công!",
            Snackbar.LENGTH_SHORT
        ).show()

        // Chuyen sang trang chu va gui thong tin
        val intent_122 = Intent(
            this,
            HomeActivity::class.java
        ).apply {
            putExtra("hoTen", nguoiDung_122.hoTen)
            putExtra("email", nguoiDung_122.email)
            putExtra("soDienThoai", nguoiDung_122.soDienThoai)
        }

        startActivity(intent_122)
    }

    private fun xoaDuLieu_122() {

        // Xoa noi dung cac o nhap
        binding.edtHoTen.text?.clear()
        binding.edtEmail.text?.clear()
        binding.edtMatKhau.text?.clear()
        binding.edtSoDienThoai.text?.clear()

        // Xoa cac thong bao loi
        binding.tilHoTen.error = null
        binding.tilEmail.error = null
        binding.tilMatKhau.error = null
        binding.tilSoDienThoai.error = null

        // Dua con tro ve o ho ten
        binding.edtHoTen.requestFocus()

        // Thong bao da xoa du lieu
        Snackbar.make(
            binding.root,
            "Đã xóa toàn bộ dữ liệu!",
            Snackbar.LENGTH_SHORT
        ).show()
    }
}