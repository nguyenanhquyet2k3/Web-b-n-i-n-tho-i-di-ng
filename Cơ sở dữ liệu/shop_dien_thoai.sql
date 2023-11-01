-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 01, 2023 lúc 10:03 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.1.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `shop_dien_thoai`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name_cate` varchar(100) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name_cate`, `status`) VALUES
(1, 'Android', 1),
(2, 'Samxung', 1),
(3, 'Iphone', 1),
(4, 'iphone 10', 1),
(5, 'iphone1', 0),
(6, 'ab', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `feedback`
--

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `money` double NOT NULL,
  `status` int(11) NOT NULL,
  `set_date` date NOT NULL,
  `adress` varchar(50) NOT NULL,
  `note` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `order_details`
--

CREATE TABLE `order_details` (
  `id` int(11) NOT NULL,
  `orders_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `quantity` float NOT NULL,
  `total_payment` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `picture`
--

CREATE TABLE `picture` (
  `id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `img` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `name_product` varchar(100) NOT NULL,
  `image` text NOT NULL,
  `information` text NOT NULL,
  `price` double NOT NULL,
  `created_at` date NOT NULL,
  `update_at` date NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`id`, `category_id`, `name_product`, `image`, `information`, `price`, `created_at`, `update_at`, `status`) VALUES
(3, 1, 'Nokia Lumia', 'product-2.jpg', 'Điện thoại Nokia Lumia 1320 là một chiếc máy “bé bự” nhưng không phải vì thế mà nó có thiết kế thô kệch, xấu xí mà hoàn toàn ngược lại. Máy được thiết kế cân đối, thanh mảnh với các góc bo tròn mềm mại. Lớp vỏ nhựa polycarbonate chất lượng cao có nhiều màu sắc giúp cho chiếc smartphone thân yêu của bạn có thể được “thay áo” trong chốc lát, tránh tạo sự nhàm chán. Độ mỏng 9,8 mm là rất ấn tượng đối với một thiết bị Phablet, kết hợp với lớp nhựa nhám cho phép bạn bỏ vào túi áo, túi quần một cách dễ dàng.', 1000000, '2023-09-30', '2023-10-01', 1),
(4, 3, 'Iphone 6', 'product-5.jpg', 'iPhone 6 là một trong những smartphone được yêu thích nhất của Apple. Lắng nghe nhu cầu về thiết kế, khả năng lưu trữ và giá cả, iPhone 6 32GB được chính thức phân phối chính hãng tại Việt Nam hứa hẹn sẽ là một sản phẩm rất \"Hot\".Vi xử lý mạnh mẽ\niPhone sử dụng chip xử lý A8 tốc độ 1.4 GHz cho việc xử lý tác vụ nhanh hơn 30%, tiết kiệm năng lượng hơn 25% so với chip A7 trên iPhone 5s (1.3 GHz), đối với việc chơi game có cấu hình nặng cũng sẽ rất dễ dàng. \n\nBộ nhớ 32GB trang bị trên máy giúp bạn thỏa thích chụp ảnh, tải game mà không lo nhanh hết dung lượng lưu trữ.', 2200000, '2023-09-30', '2023-10-01', 1),
(5, 1, 'LG Leon', 'product-3.jpg', 'LG Leon được tạo nên từ chất liệu nhựa nhưng lại được thiết kế theo phong cách giả kim loại với các đường vân ngang thể hiện rõ ở phần mặt lưng, tạo điểm nhấn hút mắt trên thiết bị. Phần mặt sau này còn gây được sự chú ý mạnh do LG đã thiết kế phím nguồn cùng nút tăng giảm âm lượng tượng tự như trên LG G3, rất thuận tiện cho ngón trỏ bật tắt nguồn.', 1300000, '2023-09-30', '2023-10-01', 1),
(7, 2, 'Samxung Galaxy note4', 'product-6.jpg', 'Samsung Galaxy Note 4 có thiết kế hoàn toàn mới với khung viền bằng kim loại được đánh bóng mép kim cương và uốn lượn hai bên hông để người dùng cầm máy dễ dàng hơn. Mặt sau là chất liệu giả da giúp cho việc cầm điện thoại trở nên thoải mái nhất. Màn hình 2K siêu nét, màu sắc chuẩn mực. Vi xử lý 8 nhân cực mạnh', 1000000, '2023-09-30', '2023-10-01', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name_role` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name_role`) VALUES
(1, 'Admin'),
(2, 'User');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fullname` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(250) NOT NULL,
  `phone` varchar(10) NOT NULL,
  `email` varchar(100) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `fullname`, `username`, `password`, `phone`, `email`, `role_id`) VALUES
(1, 'Nguyễn Văn A', 'nguyena', '$2a$10$cYc8retgPyf9qKygvmtY3OHG3.xrbcje.tCWXKvw98lmpB0p6lGYq', '0987453683', 'a@gmail.com', 1),
(2, 'Nguyễn Văn B', 'nguyenb', '1234567', '0984536472', 'b@gmail.com', 2),
(3, 'Nguyễn Văn C', 'nguyenc', '1234', '0936472861', 'c@gmail.com', 1),
(4, 'nguyen van d', 'nguyend', '12', '0975612345', 'd@gmail.com', 2),
(5, 'Nguyen Van E', 'nguyene', '12', '0983256111', 'e@gmail.com', 1),
(6, 'Nguyen Van H', 'nguyenh', '$2a$10$cYc8retgPyf9qKygvmtY3OHG3.xrbcje.tCWXKvw98lmpB0p6lGYq', '0983256111', 'h@gmail.com', 1),
(7, 'Nguyen Van H', 'nguyenh', '$2a$10$x7Ibf7SVdVehgb1uL9FhB.euSU5au91PkqI7l3Gk2AePpIQ0gjl7C', '0983256111', 'h@gmail.com', 1);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `feedback_ibfk_2` (`product_id`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `A` (`user_id`);

--
-- Chỉ mục cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD PRIMARY KEY (`id`),
  ADD KEY `C` (`product_id`),
  ADD KEY `orders_id` (`orders_id`);

--
-- Chỉ mục cho bảng `picture`
--
ALTER TABLE `picture`
  ADD PRIMARY KEY (`id`),
  ADD KEY `CD` (`product_id`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`),
  ADD KEY `BA` (`category_id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `AB` (`role_id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `feedback`
--
ALTER TABLE `feedback`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `order_details`
--
ALTER TABLE `order_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `picture`
--
ALTER TABLE `picture`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `A` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);

--
-- Các ràng buộc cho bảng `order_details`
--
ALTER TABLE `order_details`
  ADD CONSTRAINT `C` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  ADD CONSTRAINT `order_details_ibfk_1` FOREIGN KEY (`orders_id`) REFERENCES `orders` (`id`);

--
-- Các ràng buộc cho bảng `picture`
--
ALTER TABLE `picture`
  ADD CONSTRAINT `CD` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`);

--
-- Các ràng buộc cho bảng `product`
--
ALTER TABLE `product`
  ADD CONSTRAINT `BA` FOREIGN KEY (`category_id`) REFERENCES `category` (`id`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `AB` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
