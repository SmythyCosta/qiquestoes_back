-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 22-Jun-2019 às 04:55
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_qquestoes`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_area_formacao`
--

CREATE TABLE `tbl_area_formacao` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_area_formacao`
--

INSERT INTO `tbl_area_formacao` (`id`, `nome`) VALUES
(4, 'Administração'),
(8, 'Design'),
(14, 'Direito'),
(1, 'Enfermagem'),
(10, 'Matemática'),
(12, 'Medicina'),
(15, 'Tecnologia da Informação');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_assunto`
--

CREATE TABLE `tbl_assunto` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `disciplina_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_assunto`
--

INSERT INTO `tbl_assunto` (`id`, `nome`, `disciplina_id`) VALUES
(1, 'Engenharia de requisitos', 6),
(2, 'Uml', 6),
(3, 'Swing', 4),
(4, 'Jasper Report', 4),
(5, 'JDBC', 4),
(8, 'Servlet', 4);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_disciplina`
--

CREATE TABLE `tbl_disciplina` (
  `id` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `area_formacao_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_disciplina`
--

INSERT INTO `tbl_disciplina` (`id`, `nome`, `area_formacao_id`) VALUES
(1, 'Algoritomos', 15),
(2, 'Algoritomos 2', 15),
(3, 'Lógica de Programação', 15),
(4, 'Linguagem Java', 15),
(6, 'Engenharia de Sotware', 15),
(7, 'Usuabilidade Web', 8);

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id` bigint(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role_user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_user`
--

INSERT INTO `tbl_user` (`id`, `email`, `name`, `password`, `role_user`) VALUES
(1, 'smythy.costa@gmail.com', 'Smythy Carvalho cc', '12345678', 'ADMIN'),
(3, 'user2email.com', 'user2 ', '123456', 'GUEST'),
(4, 'user3email.com', 'user3', '123456', 'GUEST'),
(5, 'user4email.com', 'user4', '123456', 'GUEST'),
(6, 'user5email.com', 'user5', '123456', 'GUEST'),
(7, 'user6email.com', 'user6', '123456', 'GUEST'),
(8, 'user7email.com', 'user7', '123456', 'GUEST'),
(9, 'user8email.com', 'user8', '123456', 'GUEST'),
(10, 'user9email.com', 'user9', '123456', 'GUEST'),
(11, 'user10email.com', 'user10', '123456', 'GUEST'),
(12, 'user11email.com', 'user11', '123456', 'GUEST'),
(13, 'user12email.com', 'user12 ', '123456', 'GUEST'),
(14, 'user13email.com', 'user13', '123456', 'GUEST'),
(15, 'user14email.com', 'user14', '123456', 'GUEST'),
(16, 'user15email.com', 'user15', '123456', 'GUEST'),
(17, 'user16email.com', 'user16', '123456', 'GUEST'),
(18, 'user17email.com', 'user17', '123456', 'GUEST'),
(19, 'user18email.com', 'user18', '123456', 'GUEST'),
(20, 'user19email.com', 'user19', '123456', 'GUEST'),
(21, 'user21email.com', 'user21', '123456', 'GUEST'),
(22, 'user20email.com', 'user20', '123456', 'GUEST'),
(23, 'user32email.com', 'user32 ', '123456', 'GUEST'),
(24, 'user33email.com', 'user33', '123456', 'GUEST'),
(25, 'user34email.com', 'user34', '123456', 'GUEST'),
(26, 'user35email.com', 'user35', '123456', 'GUEST'),
(27, 'user36email.com', 'user36', '123456', 'GUEST'),
(28, 'user37email.com', 'user37', '123456', 'GUEST'),
(29, 'user38email.com', 'user38', '123456', 'GUEST'),
(30, 'user39email.com', 'user39', '123456', 'GUEST'),
(31, 'user310email.com', 'user310', '123456', 'GUEST'),
(32, 'user311email.com', 'user311', '123456', 'GUEST'),
(33, 'user42email.com', 'user42 ', '123456', 'GUEST'),
(34, 'user43email.com', 'user43', '123456', 'GUEST'),
(35, 'user44email.com', 'user44', '123456', 'GUEST'),
(36, 'user45email.com', 'user45', '123456', 'GUEST'),
(37, 'user46email.com', 'user46', '123456', 'GUEST'),
(38, 'user47email.com', 'user47', '123456', 'GUEST'),
(39, 'user48email.com', 'user48', '123456', 'GUEST'),
(40, 'user49email.com', 'user49', '123456', 'GUEST'),
(41, 'user410email.com', 'user410', '123456', 'GUEST'),
(42, 'user411email.com', 'user411', '123456', 'GUEST'),
(43, 'user52email.com', 'user52 ', '123456', 'GUEST'),
(44, 'user53email.com', 'user53', '123456', 'GUEST'),
(45, 'user54email.com', 'user54', '123456', 'GUEST'),
(46, 'user55email.com', 'user55', '123456', 'GUEST'),
(47, 'user56email.com', 'user56', '123456', 'GUEST'),
(48, 'user57email.com', 'user57', '123456', 'GUEST'),
(49, 'user58email.com', 'user58', '123456', 'GUEST'),
(50, 'user59email.com', 'user59', '123456', 'GUEST'),
(51, 'user510email.com', 'user510', '123456', 'GUEST'),
(52, 'user511email.com', 'user511', '123456', 'GUEST'),
(53, 'user62email.com', 'user62 ', '123456', 'GUEST'),
(54, 'user63email.com', 'user63', '123456', 'GUEST'),
(55, 'user64email.com', 'user64', '123456', 'GUEST'),
(56, 'user65email.com', 'user65', '123456', 'GUEST'),
(57, 'user66email.com', 'user66', '123456', 'GUEST'),
(58, 'user67email.com', 'user67', '123456', 'GUEST'),
(59, 'user68email.com', 'user68', '123456', 'GUEST'),
(60, 'user69email.com', 'user69', '123456', 'GUEST'),
(61, 'user610email.com', 'user610', '123456', 'GUEST'),
(62, 'user611email.com', 'user611', '123456', 'GUEST'),
(63, 'user72email.com', 'user72 ', '123456', 'GUEST'),
(64, 'user73email.com', 'user73', '123456', 'GUEST'),
(65, 'user74email.com', 'user74', '123456', 'GUEST'),
(66, 'user75email.com', 'user75', '123456', 'GUEST'),
(67, 'user76email.com', 'user76', '123456', 'GUEST'),
(68, 'user77email.com', 'user77', '123456', 'GUEST'),
(69, 'user78email.com', 'user78', '123456', 'GUEST'),
(70, 'user79email.com', 'user79', '123456', 'GUEST'),
(71, 'user710email.com', 'user710', '123456', 'GUEST'),
(72, 'user711email.com', 'user711', '123456', 'GUEST'),
(73, 'user82email.com', 'user82 ', '123456', 'GUEST'),
(74, 'user83email.com', 'user83', '123456', 'GUEST'),
(75, 'user84email.com', 'user84', '123456', 'GUEST'),
(76, 'user85email.com', 'user85', '123456', 'GUEST'),
(77, 'user86email.com', 'user86', '123456', 'GUEST'),
(78, 'user87email.com', 'user87', '123456', 'GUEST'),
(79, 'user88email.com', 'user88', '123456', 'GUEST'),
(80, 'user89email.com', 'user89', '123456', 'GUEST'),
(81, 'user810email.com', 'user810', '123456', 'GUEST'),
(82, 'user811email.com', 'user811', '123456', 'GUEST'),
(83, 'user92email.com', 'user92 ', '123456', 'GUEST'),
(84, 'user93email.com', 'user93', '123456', 'GUEST'),
(85, 'user94email.com', 'user94', '123456', 'GUEST'),
(86, 'user95email.com', 'user95', '123456', 'GUEST'),
(87, 'user96email.com', 'user96', '123456', 'GUEST'),
(88, 'user97email.com', 'user97', '123456', 'GUEST'),
(89, 'user98email.com', 'user98', '123456', 'GUEST'),
(90, 'user99email.com', 'user99', '123456', 'GUEST'),
(91, 'user910email.com', 'user910', '123456', 'GUEST'),
(92, 'user911email.com', 'user911', '123456', 'GUEST'),
(93, 'userr666ttt@email.com', 'Smythy Carvalho', '123456', 'ADMIN'),
(94, 'userr666ttrrrrrt@email.com', 'Smythy Carvalho2', '123456', 'ADMIN'),
(95, 'user6666666t@email.com', 'Joao baptista SUSU', '123456', 'GUEST');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_area_formacao`
--
ALTER TABLE `tbl_area_formacao`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKr1x0su38xw86urf8m4ypndvq1` (`nome`);

--
-- Indexes for table `tbl_assunto`
--
ALTER TABLE `tbl_assunto`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK4av6m79ssj55sbafwxb2clv93` (`nome`),
  ADD KEY `FKf3hj0c42qpcpa9k582y2ve0dr` (`disciplina_id`);

--
-- Indexes for table `tbl_disciplina`
--
ALTER TABLE `tbl_disciplina`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKicxnjnneamyddnf63q468x0ux` (`nome`),
  ADD KEY `FKcq9sr70l1vwjw8mex31wf5uub` (`area_formacao_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UKnpn1wf1yu1g5rjohbek375pp1` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_area_formacao`
--
ALTER TABLE `tbl_area_formacao`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `tbl_assunto`
--
ALTER TABLE `tbl_assunto`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `tbl_disciplina`
--
ALTER TABLE `tbl_disciplina`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=96;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `tbl_assunto`
--
ALTER TABLE `tbl_assunto`
  ADD CONSTRAINT `FKf3hj0c42qpcpa9k582y2ve0dr` FOREIGN KEY (`disciplina_id`) REFERENCES `tbl_disciplina` (`id`);

--
-- Limitadores para a tabela `tbl_disciplina`
--
ALTER TABLE `tbl_disciplina`
  ADD CONSTRAINT `FKcq9sr70l1vwjw8mex31wf5uub` FOREIGN KEY (`area_formacao_id`) REFERENCES `tbl_area_formacao` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
