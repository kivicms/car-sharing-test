-- --------------------------------------------------------
-- Хост:                         127.0.0.1
-- Версия сервера:               10.3.13-MariaDB - mariadb.org binary distribution
-- Операционная система:         Win64
-- HeidiSQL Версия:              10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Дамп структуры для таблица car_sharing.car
CREATE TABLE IF NOT EXISTS `car` (
  `id` int(11) NOT NULL,
  `number` varchar(255) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `mark_id` int(11) DEFAULT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  `renter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4mt4rf2euhd4unu8yo9qxi85e` (`mark_id`),
  KEY `FK684exusnbd6ey0pnby095p8ha` (`renter_id`),
  KEY `FKqybowo76x07bo268iwdi31l55` (`vendor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_sharing.car: 4 rows
DELETE FROM `car`;
/*!40000 ALTER TABLE `car` DISABLE KEYS */;
INSERT INTO `car` (`id`, `number`, `status`, `mark_id`, `vendor_id`, `renter_id`) VALUES
	(50, 'У567АВ56', 1, 1, 42, 45),
	(51, ' У456ВА67', 0, 24, 2, 54),
	(58, ' У346РА', 0, 30, 29, 45),
	(66, 'О456РУ65', 1, 65, 38, 67);
/*!40000 ALTER TABLE `car` ENABLE KEYS */;

-- Дамп структуры для таблица car_sharing.hibernate_sequence
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_sharing.hibernate_sequence: 2 rows
DELETE FROM `hibernate_sequence`;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` (`next_val`) VALUES
	(70),
	(70);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;

-- Дамп структуры для таблица car_sharing.mark
CREATE TABLE IF NOT EXISTS `mark` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `vendor_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4wle885wwuegd9y0j2ixbau2s` (`vendor_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_sharing.mark: 6 rows
DELETE FROM `mark`;
/*!40000 ALTER TABLE `mark` DISABLE KEYS */;
INSERT INTO `mark` (`id`, `name`, `vendor_id`) VALUES
	(1, 'Blazer', 1),
	(24, 'Land Cruiser', 2),
	(26, 'Rio', 25),
	(27, 'Rio 2', 25),
	(30, 'Very', 29),
	(65, 'Mini', 38);
/*!40000 ALTER TABLE `mark` ENABLE KEYS */;

-- Дамп структуры для таблица car_sharing.operation
CREATE TABLE IF NOT EXISTS `operation` (
  `id` int(11) NOT NULL,
  `end_date_time` datetime DEFAULT NULL,
  `start_date_time` datetime DEFAULT NULL,
  `car_id` int(11) DEFAULT NULL,
  `renter_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7w2mumahw9lni3p7yxy0kfigj` (`car_id`),
  KEY `FKsdxmbh3llq1bqj4234u9ug6jt` (`renter_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_sharing.operation: 11 rows
DELETE FROM `operation`;
/*!40000 ALTER TABLE `operation` DISABLE KEYS */;
INSERT INTO `operation` (`id`, `end_date_time`, `start_date_time`, `car_id`, `renter_id`) VALUES
	(55, '2019-08-04 15:48:44', '2019-08-04 15:13:20', 50, 45),
	(56, '2019-08-04 16:08:58', '2019-08-04 15:48:54', 51, 54),
	(57, '2019-08-04 16:07:23', '2019-08-04 15:49:04', 51, 32),
	(59, '2019-08-04 16:14:34', '2019-08-04 16:08:51', 58, 32),
	(60, '2019-08-04 16:14:54', '2019-08-04 16:14:41', 58, 32),
	(61, '2019-08-05 02:10:47', '2019-08-04 16:16:06', 50, 45),
	(62, '2019-08-05 05:44:00', '2019-08-04 17:14:05', 51, 54),
	(63, '2019-08-05 15:06:52', '2019-08-04 17:14:25', 58, 32),
	(64, '2019-08-06 06:54:29', '2019-08-05 16:43:32', 58, 45),
	(68, '2019-08-06 22:29:09', '2019-08-05 17:28:51', 66, 67),
	(69, NULL, '2019-08-06 06:54:25', 50, 45);
/*!40000 ALTER TABLE `operation` ENABLE KEYS */;

-- Дамп структуры для таблица car_sharing.renter
CREATE TABLE IF NOT EXISTS `renter` (
  `id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `fio` varchar(255) DEFAULT NULL,
  `passport` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_sharing.renter: 4 rows
DELETE FROM `renter`;
/*!40000 ALTER TABLE `renter` DISABLE KEYS */;
INSERT INTO `renter` (`id`, `address`, `email`, `fio`, `passport`, `phone`) VALUES
	(45, 'Оренбург, пр. Звездный 128 Д', 'v.ivanov@orb.enforta.com', 'Иванов Виталий Владимирович', 'есть', '89619379273'),
	(32, 'Пр. Звёздный 128 Д, 16', NULL, 'Иванова Надежда Владимировна', 'паспорт', '9198626205'),
	(54, 'Звездный проспект', NULL, 'Макаров Макар Макарович', '34543954 5435 435', '9619379273'),
	(67, 'Тында', NULL, 'Фиолетов Транспортир Яблокович', '345345934ш5', '3454354');
/*!40000 ALTER TABLE `renter` ENABLE KEYS */;

-- Дамп структуры для таблица car_sharing.vendor
CREATE TABLE IF NOT EXISTS `vendor` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- Дамп данных таблицы car_sharing.vendor: 7 rows
DELETE FROM `vendor`;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
INSERT INTO `vendor` (`id`, `name`) VALUES
	(1, 'Chevy'),
	(2, 'Toyota'),
	(34, '3333333333333333'),
	(38, 'Nissan'),
	(42, 'Chevrolet'),
	(29, 'Chery'),
	(25, 'Kia');
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
