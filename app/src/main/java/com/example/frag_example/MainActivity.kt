package com.example.frag_example

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
/*
Sinh viên lập trình lại ứng dụng danh bạ (đã làm trong bài tập trước) với các yêu cầu mới sau:
+ Sử dụng fragment để thực hiện các chức năng thay cho activity
+ Một fragment hiển thị danh sách
+ Tạo option menu để thêm danh bạ, sử dụng fragment để tạo giao diện thêm danh bạ
+ Khi nhấn vào 1 đối tượng trên danh sách thì mở màn hình hiển thị chi tiết danh bạ, cũng sử dụng fragment thể thực hiện màn hình chi tiết này.
Thời hạn nộp bài đến hết ngày 29/11/2023.
*/
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myFragment = BlankFragment() // Replace with your Fragment class

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragmentContainerView, myFragment) // Replace 'fragment_container' with your container id
        fragmentTransaction.commit()
    }
    }



