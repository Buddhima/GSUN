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
-- Database: `gsun_users_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `android_users`
--

CREATE TABLE IF NOT EXISTS `android_users` (
  `user_id` varchar(4) NOT NULL COMMENT 'user ids given',
  `user_name` varchar(8) NOT NULL COMMENT 'username MAX8',
  `password` varchar(200) NOT NULL COMMENT 'encrypted password',
  `email` varchar(50) NOT NULL COMMENT 'user email',
  `discription` varchar(150) DEFAULT NULL COMMENT 'user discription',
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COMMENT='all users data';

--
-- Dumping data for table `android_users`
--

INSERT INTO `android_users` (`user_id`, `user_name`, `password`, `email`, `discription`) VALUES
('asd', 'asd', 'asd', 'asd', 'asd');
