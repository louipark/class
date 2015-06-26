-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 21, 2015 at 02:02 AM
-- Server version: 5.6.11
-- PHP Version: 5.5.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `lnf`
--
CREATE DATABASE IF NOT EXISTS `lnf` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `lnf`;

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
CREATE TABLE IF NOT EXISTS `account` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(25) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Password` char(32) NOT NULL,
  PRIMARY KEY (`UserID`),
  UNIQUE KEY `Email` (`Email`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`UserID`, `Email`, `Name`, `Password`) VALUES
(1, 'jonathanjlau@yahoo.com', 'jjlau4', 'd8578edf8458ce06fbc5bb76a58c5ca4'),
(2, 'test@test.com', 'test', '98f6bcd4621d373cade4e832627b4f6'),
(3, 'admin@test.com', 'admin', '21232f297a57a5a743894a0e4a801fc3'),
(4, 'test2@test.com', 'test2', '98f6bcd4621d373cade4e832627b4f6'),
(5, 'kdhken@gmail.com', 'Ryan', '81dc9bdb52d04dc20036dbd8313ed055'),
(6, '1', '1', 'c4ca4238a0b923820dcc509a6f75849b'),
(7, 'test1', 'test1', '5a105e8b9d40e1329780d62ea2265d8a'),
(8, 'test2', 'test2', 'ad0234829205b9033196ba818f7a872b');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id` int(11) NOT NULL,
  `categoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `categoryName`) VALUES
(1, 'electronics'),
(2, 'clothing');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(255) NOT NULL,
  `subcategoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `companyName`, `subcategoryName`) VALUES
(1, 'alienware', 'laptop'),
(2, 'iphone', 'phone'),
(3, 'burberry', 'jacket'),
(4, 'prada', 'gloves');

-- --------------------------------------------------------

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `description` varchar(500) NOT NULL,
  `color` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `time` datetime NOT NULL,
  `finderEmail` varchar(255) NOT NULL,
  `ownerEmail` varchar(255) NOT NULL,
  `categoryName` varchar(255) NOT NULL,
  `subcategoryName` varchar(255) NOT NULL,
  `companyName` varchar(255) NOT NULL,
  `active` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=53 ;

--
-- Dumping data for table `items`
--

INSERT INTO `items` (`id`, `name`, `description`, `color`, `location`, `time`, `finderEmail`, `ownerEmail`, `categoryName`, `subcategoryName`, `companyName`, `active`) VALUES
(28, 'Acer Laptop', '', 'White', '-36.597913896972855,12.656256034970284', '2015-04-06 20:43:00', '', '1', 'Electronics', 'Laptop', 'Acer', 1),
(32, 'N/A Jacket/Coat', '', 'White', '-12.382944384827352,-19.33594588190317', '2015-04-06 22:59:00', '', '1', 'Clothing', 'Jacket/Coat', 'N/A', 1),
(33, 'Burberry Jacket/Coat', '', 'White', '-42.5531077039007,-29.003919661045074', '2015-04-06 23:11:00', '', '1', 'Clothing', 'Jacket/Coat', 'Burberry', 1),
(34, 'Apple Tablet/iPad', '', 'Black', '50.51343825240472,-35.507826916873455', '2015-04-06 23:17:00', '', '1', 'Electronics', 'Tablet/iPad', 'Apple', 1),
(37, 'Alienware M17x', '', 'red', '40.689060, -74.044636', '2015-04-02 00:00:00', 'admin@test.com', '', 'electronics', 'laptop', 'alienware', 1),
(38, 'Alienware M17x', '', 'red', '40.689060, -74.044636', '2015-04-02 00:00:00', '', 'admin@test.com', 'electronics', 'laptop', 'alienware', 1),
(39, 'Alienware M17x', '', 'red', '-36.597913896972855,12.656256034970284', '2015-04-06 20:43:00', 'admin@test.com', '', 'electronics', 'laptop', 'alienware', 1),
(40, 'Alienware M17x', '', 'red', '-36.597913896972855,12.656256034970284', '2015-04-06 20:43:00', '', 'admin@test.com', 'electronics', 'laptop', 'alienware', 1),
(41, 'Alienware M17x', '', 'red', '40.689060, -74.044636', '2015-04-02 00:00:00', 'admin@test.com', '', 'electronics', 'laptop', 'alienware', 1),
(42, 'Alienware M17x', '', 'red', '40.689060, -74.044636', '2015-04-02 00:00:00', '', 'admin@test.com', 'electronics', 'laptop', 'alienware', 1),
(43, 'Acer Laptop', '', 'White', '37.431547621861135,-122.08752829581498', '2015-04-10 18:56:00', '', 'test1', 'Electronics', 'Laptop', 'Acer', 1),
(44, 'Dell Laptop', '', 'Black', '37.44377245095916,-122.10086155682801', '2015-04-10 18:59:00', '', 'test1', 'Electronics', 'Laptop', 'Dell', 1),
(45, 'Acer Laptop', '', 'White', '37.43164985645037,-122.08752829581498', '2015-04-10 19:02:00', 'test2', '', 'Electronics', 'Laptop', 'Acer', 1),
(46, 'Dell Laptop', '', 'Black', '37.44371708287686,-122.10083171725273', '2015-04-10 19:03:00', 'test2', '', 'Electronics', 'Laptop', 'Dell', 1),
(47, 'Alienware M17x', '', 'red', '-36.597913896972855,12.656256034970284', '2015-04-06 20:43:00', 'admin@test.com', '', 'electronics', 'laptop', 'alienware', 1),
(48, 'Alienware M17x', '', 'red', '-36.597913896972855,12.656256034970284', '2015-04-06 20:43:00', '', 'admin@test.com', 'electronics', 'laptop', 'alienware', 1),
(49, 'Alienware M17x', '', 'red', '40.689060, -74.044636', '2015-04-02 00:00:00', 'admin@test.com', '', 'electronics', 'laptop', 'alienware', 1),
(50, 'Alienware M17x', '', 'red', '40.689060, -74.044636', '2015-04-02 00:00:00', '', 'admin@test.com', 'electronics', 'laptop', 'alienware', 1),
(51, 'Alienware M17x', '', 'red', '-36.597913896972855,12.656256034970284', '2015-04-06 20:43:00', 'admin@test.com', '', 'electronics', 'laptop', 'alienware', 1),
(52, 'Alienware M17x', '', 'red', '-36.597913896972855,12.656256034970284', '2015-04-06 20:43:00', '', 'admin@test.com', 'electronics', 'laptop', 'alienware', 1);

-- --------------------------------------------------------

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
CREATE TABLE IF NOT EXISTS `messages` (
  `id` int(11) NOT NULL,
  `senderEmail` varchar(255) NOT NULL,
  `receiverEmail` varchar(255) NOT NULL,
  `itemID` int(11) NOT NULL,
  `finderHasRead` tinyint(1) NOT NULL,
  `ownerHasRead` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `messages`
--

INSERT INTO `messages` (`id`, `senderEmail`, `receiverEmail`, `itemID`, `finderHasRead`, `ownerHasRead`) VALUES
(1, 'admin@test.com', 'test@test.com', 1, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `subcategory`
--

DROP TABLE IF EXISTS `subcategory`;
CREATE TABLE IF NOT EXISTS `subcategory` (
  `id` int(11) NOT NULL,
  `subcategoryName` varchar(255) NOT NULL,
  `categoryName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `subcategory`
--

INSERT INTO `subcategory` (`id`, `subcategoryName`, `categoryName`) VALUES
(1, 'phone', 'electronics'),
(2, 'laptop', 'electronics'),
(3, 'jacket', 'clothing'),
(4, 'gloves', 'clothing');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
