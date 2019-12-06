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
-- Database: `db_qiquestoes`
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
	
	
	
	
	
	
	
	
-- Copiando estrutura para tabela db_qiquestoes.tbl_auth_role
DROP TABLE IF EXISTS `tbl_auth_role`;
CREATE TABLE IF NOT EXISTS `tbl_auth_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9toxbpw40wkspt92d0oixiyjs` (`name`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_qiquestoes.tbl_auth_role: 2 rows
DELETE FROM `tbl_auth_role`;
INSERT INTO `tbl_auth_role` (`id`, `name`) VALUES
	(3, 'ROLE_ADMIN'),
	(4, 'ROLE_USER');

-- Copiando estrutura para tabela db_qiquestoes.tbl_auth_user
DROP TABLE IF EXISTS `tbl_auth_user`;
CREATE TABLE IF NOT EXISTS `tbl_auth_user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `username` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK93a7glmxafrfym6fwvstogiu4` (`username`),
  UNIQUE KEY `UKapo0p62lgrl046pr9cr3mrnsn` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_qiquestoes.tbl_auth_user: 2 rows
DELETE FROM `tbl_auth_user`;
INSERT INTO `tbl_auth_user` (`id`, `active`, `email`, `name`, `password`, `username`) VALUES
	(3, '0', 'guest2@email.com', 'guest2', '$2a$10$oQMfzO2hYZGgXwwx2QdoyOwcwMcYoMKnm2MQV4zBhAlWSkzfW1VuK', 'guest2'),
	(2, '1', 'guest@email.com', 'guest', '$2a$10$zYXfWaWVAGXYgxAYZbHzG.yg7GM1lpQjRBpJQB6E5pqtMmECtClpa', 'guest'),
	(1, '1', 'admin@email.com', 'admin', '$2a$10$IVe2jYqI3XrOHix/eAbb6Oe/6W5tMVe5QWPPH8ur/nWqgUpAsUxjW', 'admin');
;

-- Copiando estrutura para tabela db_qiquestoes.tbl_auth_user_role
DROP TABLE IF EXISTS `tbl_auth_user_role`;
CREATE TABLE IF NOT EXISTS `tbl_auth_user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKfgdy4tc8876n25omfwbmjnbfq` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela db_qiquestoes.tbl_auth_user_role: 2 rows
DELETE FROM `tbl_auth_user_role`;
INSERT INTO `tbl_auth_user_role` (`user_id`, `role_id`) VALUES
	(1, 3),
	(2, 4);
