-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 15, 2020 lúc 01:02 PM
-- Phiên bản máy phục vụ: 10.4.6-MariaDB
-- Phiên bản PHP: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `thietbi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdonhang`
--

CREATE TABLE `chitietdonhang` (
  `id` int(11) NOT NULL,
  `madonhang` int(11) NOT NULL,
  `masanpham` int(11) NOT NULL,
  `tensanpham` varchar(2000) NOT NULL,
  `giasanpham` int(11) NOT NULL,
  `soluongsanpham` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `chitietdonhang`
--

INSERT INTO `chitietdonhang` (`id`, `madonhang`, `masanpham`, `tensanpham`, `giasanpham`, `soluongsanpham`) VALUES
(1, 17, 2, 'Điện thoại ASUS Zenfone Max Plus M1 - ZB570TL', 27450000, 5),
(2, 18, 1, 'Điện thoại iPhone X 256GB', 104370000, 3),
(3, 18, 2, 'Điện thoại ASUS Zenfone Max Plus M1 - ZB570TL', 5490000, 1),
(5, 19, 1, 'Điện thoại iPhone X 256GB', 34790000, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `donhang`
--

CREATE TABLE `donhang` (
  `id` int(11) NOT NULL,
  `tenkhachhang` varchar(200) NOT NULL,
  `sodienthoai` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `donhang`
--

INSERT INTO `donhang` (`id`, `tenkhachhang`, `sodienthoai`, `email`) VALUES
(1, 'phat', '123123123', 'phat@gmail.com'),
(2, 'Anh', '89461652', 'quangvietntd@gmail.com'),
(3, 'Anh', '89461652', 'quangvietntd@gmail.com'),
(4, 'nhut', '89461652', 'quangvietntd@gmail.com'),
(5, 'nhưt', '0', 'nhut@gmail.com'),
(6, 'nhưt', '989223987', 'nhut@gmail.com'),
(7, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(8, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(9, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(10, 'nhut', '123', 'quangvietntd@gmail.com'),
(11, 'nhut', '2147483647', 'quangvietntd@gmail.com'),
(12, 'nhut', '123456789123', 'quangvietntd@gmail.com'),
(13, 'nhut', '0989223787', 'quangvietntd@gmail.com'),
(14, 'Anh', '123456', 'quangvietntd@gmail.com'),
(15, 'Việt Nam', '09895641', 'quangvietntd@gmail.com'),
(16, 'Anh tin', '4455761849', 'quangvietntd@gmail.com'),
(17, 'Anh tin', '09846', 'quangvietntd@gmail.com'),
(18, 'quang nhut', '08521470852', 'nhut@gmail.com'),
(19, 'Nguyen Quang Viet', '0984510852', 'quangvietntd@gmail.com'),
(20, 'Nguyen Quang Viet', '0984510852', 'quangvietntd@gmail.com'),
(21, 'Long', '1234567', 'longbeo');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `loaisanpham`
--

CREATE TABLE `loaisanpham` (
  `id` int(11) NOT NULL,
  `tenloaisanpham` varchar(200) NOT NULL,
  `hinhanhloaisanpham` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `loaisanpham`
--

INSERT INTO `loaisanpham` (`id`, `tenloaisanpham`, `hinhanhloaisanpham`) VALUES
(1, 'Điện thoại', 'https://d30y9cdsu7xlg0.cloudfront.net/png/37361-200.png'),
(2, 'Ipad', 'https://cdn3.iconfinder.com/data/icons/other-icons/48/ipad-512.png');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `sanpham`
--

CREATE TABLE `sanpham` (
  `id` int(11) NOT NULL,
  `tensanpham` varchar(200) NOT NULL,
  `giasanpham` int(15) NOT NULL,
  `hinhanhsanpham` varchar(200) NOT NULL,
  `motasanpham` varchar(10000) NOT NULL,
  `idsanpham` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `sanpham`
--

INSERT INTO `sanpham` (`id`, `tensanpham`, `giasanpham`, `hinhanhsanpham`, `motasanpham`, `idsanpham`) VALUES
(1, 'Điện thoại iPhone X 256GB', 34790000, 'https://cdn.tgdd.vn/Products/Images/42/114111/iphone-x-256gb-h2-400x460.png', 'iPhone X được Apple ra mắt ngày 12/9 vừa rồi đánh dấu chặng đường 10 năm lần đầu tiên iPhone ra đời. Sau một thời gian, giá iPhone X cũng được công bố. iPhone X mang trên mình thiết kế hoàn toàn mới với màn hình Super Retina viền cực mỏng và trang bị nhiều công nghệ hiện đại như nhận diện khuôn mặt Face ID, sạc pin nhanh và sạc không dây cùng khả năng chống nước bụi cao cấp.', 1),
(2, 'Điện thoại ASUS Zenfone Max Plus M1 - ZB570TL', 5490000, 'https://cdn.tgdd.vn/Products/Images/42/139346/asus-zenfone-max-m1-plus-zb570tl-1-400x460.png', 'Zenfone Max Plus M1 là chiếc smartphone theo xu thế màn hình viền mỏng đầu tiên của ASUS. Với ưu điểm thiết kế đẹp, pin lớn truyền thống dòng Zenfone Max, camera kép và mức giá tầm trung cực kì hấp dẫn và đáng sở hữu.', 1),
(3, 'Điện thoại Xiaomi Redmi Note 5A (Redmi Y1 Lite)', 2990000, 'https://cdn.tgdd.vn/Products/Images/42/112972/xiaomi-redmi-note-5a-400x460.png', 'Xiaomi Redmi Note 5A là chiếc smartphone giá rẻ, có màn hình lớn sắc nét, chạy hệ điều hành Android 7.0 với giao diện MIUI 8 tuyệt đẹp và camera selfie nhiều chế độ làm đẹp hấp dẫn', 1),
(4, 'Điện thoại iPhone 8 Plus 256GB', 28790000, 'https://cdn.tgdd.vn/Products/Images/42/114114/iphone-8-plus-256gb2-400x460-1-400x460.png', 'iPhone 8 Plus là bản nâng cấp nhẹ của chiếc iPhone 7 Plus đã ra mắt trước đó với cấu hình mạnh mẽ cùng camera có nhiều cải tiến.', 1),
(5, 'Điện thoại Samsung Galaxy S9+ 64GB', 23490000, 'https://cdn.tgdd.vn/Products/Images/42/147939/samsung-galaxy-s9-plus-3-400x460.png', 'Samsung Galaxy S9 Plus, siêu phẩm smartphone hàng đầu trong thế giới Android đã ra mắt với màn hình vô cực, camera chuyên nghiệp như máy ảnh và hàng loạt những tính năng cao cấp đầy hấp dẫn.', 1),
(6, 'Điện thoại Sony Xperia XZ Premium Pink Gold', 14490000, 'https://cdn.tgdd.vn/Products/Images/42/113126/sony-xperia-xz-premium-pink-gold-400x460.png', 'Sony Xperia XZ Premium Pink Gold là một phiên bản khác của chiếc Sony Xperia XZ Premium với khác biệt duy nhất đến từ màu Pink Gold quyến rũ.', 1),
(7, 'Điện thoại OPPO F7 128GB', 9990000, 'https://cdn.tgdd.vn/Products/Images/42/158464/oppo-f7-128gb-den-400x460.png', 'Tiếp nối sự thành công của OPPO F5 thì OPPO tiếp tục giới thiệu OPPO F7 128GB với mức giá tương đương nhưng mang trong mình thiết kế hoàn toàn mới cũng nhiều cải tiến đáng giá.', 1),
(8, 'Điện thoại HTC U Ultra', 9890000, 'https://cdn.tgdd.vn/Products/Images/42/90772/htc-u-ultra-2-400x460.png', 'HTC U Ultra đánh dấu sự trở lại của HTC với triết lý thiết kế mới, đẹp hơn - sang trọng - bóng bẩy hơn và đặc biệt gắn bó với người dùng hơn thông qua trợ lý ảo HTC Sense Companion.', 1),
(9, 'Điện thoại Bphone 2017', 9790000, 'https://cdn.tgdd.vn/Products/Images/42/75001/bkav-bphone-2-hero-400x460.png', 'Bphone 2017 là chiếc smartphone thế hệ thứ 2 được nhà sản xuất Việt Nam Bkav trình làng với hàng loạt cải tiến vượt trội, tối ưu tốt nhất cho người Việt và giá bán rất tốt.', 1),
(10, 'Điện thoại OPPO F5 6GB', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/142106/oppo-f5-6gb-a-2-400x460.png', 'OPPO F5 6GB là phiên bản nâng cấp cấu hình của chiếc OPPO F5, chuyên gia selfie làm đẹp thông minh và màn hình tràn viền tuyệt đẹp.', 1),
(11, 'Điện thoại Motorola Moto X4', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/113327/motorola-moto-x4-den-400x460.png', 'Motorola Moto X4 là một chiếc smartphone tầm trung với điểm nhấn tới từ cụm camera kép ở mặt lưng.', 1),
(12, 'Điện thoại Nokia 7 plus', 8990000, 'https://cdn.tgdd.vn/Products/Images/42/153854/nokia-7-plus-5-400x460.png', 'Nokia 7 Plus là chiếc smartphone đầu tiên đánh dấu bước đi đầu tiên của HMD vào thế giới màn hình tỉ lệ 18:9.', 1),
(13, 'Điện thoại Vivo V9', 7990000, 'https://cdn.tgdd.vn/Products/Images/42/155047/vivo-v9-1-2-400x460-400x460.png', 'Vivo V9 là chiếc smartphone tầm trung cận cao cấp với điểm nhấn là máy có camera kép phía sau và camera selfie độ phân giải cao 24 MP.', 1),
(14, 'Điện thoại Sony Xperia XA1 Ultra', 7990000, 'https://cdn.tgdd.vn/Products/Images/42/92074/sony-xa1-ultra-trang-1-400x460.png', 'Kế nhiệm sự thành công của phablet không viền Sony Xperia XA Ultra thì Sony giới thiệu phiên bản XA1 Ultra với nhiều cải tiến đáng giá.', 1),
(15, 'Điện thoại Samsung Galaxy J7+', 7290000, 'https://cdn.tgdd.vn/Products/Images/42/112970/samsung-galaxy-j7-plus-1-400x460.png', 'Samsung Galaxy J7+ là dòng smartphone tầm trung nhưng được trang bị camera kép có khả năng chụp ảnh xóa phông chân dung cùng thiết kế đẹp và hiệu năng mạnh mẽ.', 1),
(16, 'Điện thoại Samsung Galaxy Note 8', 22490000, 'https://cdn.tgdd.vn/Products/Images/42/106211/samsung-galaxy-note8-1-400x460.png', 'Galaxy Note 8 là niềm hy vọng vực lại dòng Note danh tiếng của Samsung với diện mạo nam tính, sang trọng. Trang bị camera kép xóa phông thời thượng, màn hình vô cực như trên S8 Plus, bút Spen với nhiều tính năng mới và nhiều công nghệ được Samsung ưu ái đem lên Note 8.', 1),
(17, 'Điện thoại OPPO F3 Plus', 7490000, 'https://cdn.tgdd.vn/Products/Images/42/92569/oppo-f3-plus-1-1-400x460.png', 'Sau sự thành công của OPPO F1 Plus, OPPO F3 Plus đang được người dùng quan tâm yêu thích với cụm camera selfie kép, công nghệ chụp thiếu sáng đỉnh cao, cấu hình mạnh mẽ và tất nhiên đó là thiết kế nguyên khối quá ư là sang trọng.', 1),
(18, 'Điện thoại Huawei Nova 3e Hồng', 6990000, 'https://cdn.tgdd.vn/Products/Images/42/159569/huawei-nova-3e-hong-1-400x460.png', 'Là phiên bản nâng cấp của Nova 2i, Huawei Nova 3e hồng được thừa hưởng những xu hướng mới như màn hình tràn viền cùng tai thỏ thời thượng, cùng nhiều tính năng mới cao cấp.', 1),
(19, 'Điện thoại Xiaomi Mi A1 64GB', 5490000, 'https://cdn.tgdd.vn/Products/Images/42/113572/xiaomi-mi-a1-mau-vang-hong-400x460.png', 'Mi A1 được Xiaomi chính thức ra mắt tại Ấn Độ với vai trò là một dự án hợp tác Android One của Google. Hãy cùng mình trên tay nhanh chiếc máy chạy Android thuần cùng camera xóa phông ảo diệu mà giá chỉ hơn 5 triệu này nhé.', 1),
(20, 'iPhone 11 128GB', 23990000, 'https://cdn.fptshop.com.vn/Uploads/Originals/2019/9/11/637037652463329577_11-do.png', 'Phiên bản iPhone 11 128GB được người dùng yêu thích bởi dung lượng bộ nhớ đủ dùng, camera kép cực đỉnh và những lựa chọn màu sắc vô cùng thời trang.', 1),
(22, 'Điện thoại Nokia 3', 2790000, 'https://cdn.tgdd.vn/Products/Images/42/91853/nokia-3-3-400x460.png', 'Thương hiệu Nokia vẫn rất được người dùng tin tưởng và đón chờ, năm nay hãng cũng đã đánh dấu sự trở lại với 3 mẫu điện thoại, Nokia 3 là một trong số đó.', 1),
(23, 'iPhone 11 Pro Max 64GB', 33990000, 'https://galaxydidong.vn/wp-content/uploads/2019/10/thumb_11Pro_2.jpg', 'iPhone 11 Pro Max sở hữu màn hình đáng tiền, với kích thước 6.5 inch cùng tấm nền OLED được tinh chỉnh lại bởi Apple. Màn hình này còn được hỗ trợ công nghệ True Tone giúp điều chỉnh cân bằng trắng sao cho phù hợp với điều kiện ánh sáng xung quanh', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `donhang`
--
ALTER TABLE `donhang`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `chitietdonhang`
--
ALTER TABLE `chitietdonhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT cho bảng `donhang`
--
ALTER TABLE `donhang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT cho bảng `loaisanpham`
--
ALTER TABLE `loaisanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `sanpham`
--
ALTER TABLE `sanpham`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=43;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
