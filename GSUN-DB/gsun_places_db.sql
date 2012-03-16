-- phpMyAdmin SQL Dump
-- version 3.2.0.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 16, 2012 at 03:48 PM
-- Server version: 5.1.36
-- PHP Version: 5.3.0

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `gsun_places_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `dictionary`
--

CREATE TABLE IF NOT EXISTS `dictionary` (
  `need` varchar(20) NOT NULL COMMENT 'user need',
  `type` varchar(20) NOT NULL COMMENT 'category that belongs ',
  `longitude` varchar(20) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `shop_id` varchar(8) NOT NULL,
  KEY `longitude` (`longitude`),
  KEY `latitude` (`latitude`),
  KEY `shop_id` (`shop_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dictionary`
--

INSERT INTO `dictionary` (`need`, `type`, `longitude`, `latitude`, `shop_id`) VALUES
('Books', 'Stationary', '80.22055530548096', '6.037437570469414', '1'),
('Pen', 'Stationary', '80.22055530548096', '6.037437570469414', '1'),
('Paper', 'Stationary', '80.22055530548096', '6.037437570469414', '1'),
('Stickers', 'Stationary', '80.22055530548096', '6.037437570469414', '1'),
('Printouts', 'Stationary', '80.22055530548096', '6.037437570469414', '1'),
('Newspapers', 'Stationary', '80.21891379356384', '6.034678208665372', '2'),
('CD', 'Computer', '80.21891379356384', '6.034678208665372', '2'),
('Books', 'Stationary', '80.21891379356384', '6.034678208665372', '2'),
('Pen', 'Stationary', '80.21891379356384', '6.034678208665372', '2'),
('Papers', 'Stationary', '80.21891379356384', '6.034678208665372', '2');

-- --------------------------------------------------------

--
-- Table structure for table `shops`
--

CREATE TABLE IF NOT EXISTS `shops` (
  `shop_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'shop id',
  `shop_name` varchar(20) NOT NULL COMMENT 'name of the shop',
  `longitude` varchar(20) NOT NULL COMMENT 'to east',
  `latitude` varchar(20) NOT NULL COMMENT 'to north',
  `address` varchar(50) NOT NULL,
  `telephone_no` varchar(12) NOT NULL COMMENT 'international format',
  `email` varchar(20) NOT NULL,
  `discription` varchar(150) NOT NULL COMMENT 'info about shop',
  KEY `shop_id_2` (`shop_id`),
  KEY `shop_id` (`shop_id`),
  KEY `longitude` (`longitude`),
  KEY `latitude` (`latitude`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `shops`
--

INSERT INTO `shops` (`shop_id`, `shop_name`, `longitude`, `latitude`, `address`, `telephone_no`, `email`, `discription`) VALUES
(1, 'Ariyadasa Bookshop', '80.22055530548096', '6.037437570469414', '26,\r\nOlcot Road,\r\nGalle', '+94911234567', 'ariyadasa@sltnet.lk', 'Best Book Seller in Galle'),
(2, 'Aradhana Bookshop', '80.21891379356384', '6.034678208665372', '2,\r\nMain Street,\r\nGalle', '+94911234567', 'aradhana@gmail.com', 'Newspaper seller');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dictionary`
--
ALTER TABLE `dictionary`
  ADD CONSTRAINT `dictionary_ibfk_1` FOREIGN KEY (`longitude`) REFERENCES `shops` (`longitude`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `dictionary_ibfk_2` FOREIGN KEY (`latitude`) REFERENCES `shops` (`latitude`) ON DELETE CASCADE ON UPDATE CASCADE;
