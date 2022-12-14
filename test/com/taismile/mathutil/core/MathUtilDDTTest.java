/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taismile.mathutil.core;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static com.taismile.mathutil.core.MathUtil.*;

/**
 *
 * @author Tài Smile
 */
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {

    @Parameterized.Parameters
    public static Object[][] initData(){
        int a[] = {5, 10, 15, 20, 25};//liệt kê các phần tử mảng cách nhau
        int b[][] = {{1, 0}, {1, 1}, {2, 2}, {6, 3}, {24, 4}, {120, 5}, {720, 6}};
//        int c[][] =  {{1, 0},
//                      {1, 1}, 
//                      {2, 2}, 
//                      {6, 3}, 
//                      {24, 4}, 
//                      {120, 5}, 
//                      {720, 6}};
        return new Integer[][] {{1, 0},
                                {1, 1}, 
                                {2, 2}, 
                                {6, 3}, 
                                {24, 4}, 
                                {120, 5}, 
                                {720, 6}};
    }   
    
    //ta sẽ map/ánh xạ các cột của mỗi dòng, ví dụ dòng đầu tiên
    //có 2 cột là 1 0 -> ta sẽ ánh xạ 1 vào biến expected, 0 vào biến n
    //tương tự cho các dòng còn lại
    @Parameterized.Parameter(value = 0)
    public long expected;//map vào cột 0 của mảng

    @Parameterized.Parameter(value = 1)
    public int n;//map vào cột 1 của mảng
    
    @Test//kiểm thử các test case với data đc trích ra từ mảng và map vào 2 biếng
         //  tương ứng
    public void testFactorialGivenRightArgumentReturnWell(){
        assertEquals(expected, getFactorial(n)); 
    }
}

//Phân tích cách ta viết code cho phần test hàm getF() hôm trước
// Assert.assertEquals(6, MathUtil.getFactorial(0)); 
//lệnh dùng để test
//hàm/method. Lệnh này lặp đi lặp lại cho các data ta đưa vào
//để ta kiểm tra các tình huống xài hàm/test case
//Lát hồi ta thay data 1 0 thành các data tương ứng khác
//Ví dụ:
//Expected      n!
//1             0  -> có ổn ko
//1             1
//2             2
//6             3
//24            4
//120           5
//720           6
//...
//[7][2]
//NẾU TA CÓ DC CÁCH NÀO ĐÓ, MÀ TÁCH ĐÁM DATA RA RIÊNG 1 CHỖ
//SAU ĐÓ TỪ TỪ NHỒI/MỚM/FEED DATA NÀY VÀO CÂU LỆNH TEST HÀM Ở TRÊN
//COI NHƯ CHỈ CẦN 1 LỆNH GỌI TEST HÀM, DATA CỨ THẾ TUẦN TỰ ĐẨY VÀO
//KĨ THUẬT TÁCH DATA RA KHỎI CÁC CÂU LỆNH TEST, SAU ĐÓ NHỒI NÓ VÔ 
// CÁI CÂU LỆNH TEST, GIÚP RÚT GỌN SỐ CÂU LỆNH TEST, GIÚP DỄ DÀNG
//KIỂM TRA TÍNH THIẾU ĐỦ CỦA CÁC TEST CASE
//KĨ THUẬT NÀY GỌI TÊN LÀ DDT - DATA DRIVEN TESTING
//Viết code kiểm thử hướng theo data
//CÒN GỌI 1 TÊN KHÁC LÀ: KIỂM THỬ THEO KIỂU THAM SỐ HÓA - PARAMETERIZE
//Dấu ??? ở câu lệnh gọi hàm chính là tên biến sẽ dùng để nhận
//data từ tập data đã tách ra - CONVERT DATA THÀNH BIẾN

//Chơi với DDT ta cần
//Bộ data test - tách riêng
//Các tham số ứng với bộ data - chính là các biến dùng trích data ra
//Gọi hàm kiểm thử xài các tham số

//TOÀN BỘ CODE TRONG CLASS NÀY ĐC VIẾT RA DÙNG ĐẺ TEST CODE CHÍNH Ở 
//BÊN SRC PACKAGES
//CODE ĐC VIẾT RA DÙNG ĐỂ ĐI TEST CODE KHÁC KHÁC
//THÌ CODE NÀY ĐC GỌI LÀ TEST SCRIPT
//1 TEST SCRIPT SẼ CHỨA NHIỀU CODE ĐỂ TEST HÀM CHÍNH
//1 TEST SCRIPT SẼ CHỨA NHIỀU TEST CASE
//                            TEST CASE: CÁC TÌNH HUỐNG XÀI HÀM
//1 TEST SCRIPT CÓ THỂ XÀI DDT ĐỂ DỄ BẢO TRÌ CODE TEST
//VIẾT VIẾT CODE CHÍNH CÓ THỂ XÀI TDD
