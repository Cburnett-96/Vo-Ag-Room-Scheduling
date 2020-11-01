-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 29, 2019 at 07:48 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ccsrmschedule`
--

-- --------------------------------------------------------

--
-- Table structure for table `old_hs_lib`
--

CREATE TABLE `old_hs_lib` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `old_hs_lib`
--

INSERT INTO `old_hs_lib` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:30 - 12:00', 'KOMFIL\r\nFilipino Instructor\r\nBSIT 1-D', 'KOMFIL\r\nFilipino Instructor\r\nBSIT 1-C', 'KOMFIL\r\nFilipino Instructor\r\nBSIT 1-D', 'KOMFIL\r\nFilipino Instructor\r\nBSIT 1-C', ''),
('1:00 - 2:30', 'KOMFIL\r\nFilipino Instructor\r\nBSCS 1-B', 'KOMFIL\r\nMrs. C. Sancon\r\nBSIT 1-A', 'KOMFIL\r\nFilipino Instructor\r\nBSCS 1-B', 'KOMFIL\r\nMrs. C. Sancon\r\nBSIT 1-A', ''),
('2:30 - 4:00', 'KOMFIL\r\nFilipino Instructor\r\nBSCS 1-A', 'KOMFIL\r\nFilipino Instructor\r\nBSIS 1-A', 'KOMFIL\r\nFilipino Instructor\r\nBSCS 1-A', 'KOMFIL\r\nFilipino Instructor\r\nBSIS 1-A', ''),
('4:00 - 5:00', 'GEC 101\r\nMs. Vispo\r\nBSCS 1-B', 'GEC 106\r\nMs. Diaz\r\nBSCS 2-A', 'ENGL 311\r\nMs. Carbungco\r\nBSIT 3-A', 'GEC 106\r\nMs. Diaz', ''),
('7:00 - 9:00', '', '', '', 'GEC 101\r\nMs. Vispo\r\nBSCS1-B', ''),
('7:30 - 9:00', 'GEC 102\r\nSoc.Scie. Instructor 7\r\nBSIT 1-B', '', 'GEC 102\r\nSoc.Scie. Instructor 7\r\nBSIT 1-B', '', ''),
('9:00 - 10:30', 'GEC 102\r\nSoc.Scie. Instructor 6\r\nBSIT 1-C', 'GEC 101\r\nMs. Vispo\r\nBSCS1-A', 'GEC 102\r\nSoc.Scie. Instructor 6\r\nBSIT 1-C', 'GEC 101\r\nMs. Vispo\r\nBSCS1-A', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_101`
--

CREATE TABLE `room_101` (
  `Period` varchar(250) NOT NULL,
  `Monday` varchar(250) NOT NULL,
  `Tuesday` varchar(250) NOT NULL,
  `Wednesday` varchar(250) NOT NULL,
  `Thursday` varchar(250) NOT NULL,
  `Friday` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_101`
--

INSERT INTO `room_101` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('11:00 - 12:00', 'BSP\r\nMrs.J. Adrias', 'ISEP 202\r\nMr. F. Urera Jr.\r\nBSIS 2-A', '', '', ''),
('12:30 - 2:00', '', '', 'ISDM 201\r\nMr. F. Urera Jr.\r\nBSIS 1-A', '', ''),
('12:30 - 2:30', 'ENGL 311 \r\nMs. Carbungco \r\nBSIT 3-A', '', '', '', ''),
('1:00 - 2:30', '', 'ITEC 101\r\nMR.F.SANDOVAL\r\nBSCS 1-B', '', '', ''),
('1:00 - 3:00', '', '', '', 'Math 24\r\nBSIT 1-B', ''),
('2:00 - 4:00', '', '', 'ISEP202\r\nMr. F. Urera Jr.\r\nBSIS 1-A', '', ''),
('3:00 - 5:00', '', '', '', 'KOMFIL\r\nFilipino Instructor\r\nBSIT 1-B', ''),
('3:30 - 4:00', '', 'ITEC 101\r\nMR.F.SANDOVAL\r\nBSCS 1-B', '', '', ''),
('4:00 - 5:00', '', 'GEM 301 (PI 100)\r\nSoc.Scie. Instructor 4\r\nBSCS1-B', 'KOMFIL\r\nFilipino Instructor\r\nBSIT 1-B', '', ''),
('7:00 - 9:00', '', '', 'ITEC 101\r\nMr. R. Diaz\r\nBSIS 1-A', '', ''),
('7:30 - 9:00', 'GEC 101\r\nMr. Gasco\r\nBSIT 1-A', '', '', '', ''),
('8:00 - 9:30', '', 'GEC 103\r\nMr. Ganibo\r\nBSIS 1-A', '', 'GEC 103\r\nMr. Ganibo\r\nBSIS 1-A', ''),
('9:30 - 11:00', 'BPO 101\r\nMrs. J. Adrias\r\nBSIT 3-A ', 'BPO 101\r\nMrs. J. Adrias\r\nBSIT 3-A ', '', '', ''),
('9:30 - 11:30', '', '', '', 'GEM 301 (PI 100)\r\nSoc.Scie. Instructor 4\r\nBSCS1-B', ''),
('9:30 - 12:00', '', '', 'ICT\r\nMr. De Jesus\r\nBSAB 1C', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_102`
--

CREATE TABLE `room_102` (
  `Period` varchar(250) NOT NULL,
  `Monday` varchar(250) NOT NULL,
  `Tuesday` varchar(250) NOT NULL,
  `Wednesday` varchar(250) NOT NULL,
  `Thursday` varchar(250) NOT NULL,
  `Friday` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_102`
--

INSERT INTO `room_102` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:30 - 12:00', '', 'GEC 102\r\nSoc.Scie. Instructor 7\r\nBSIT 1-D', '', '', ''),
('10:30 - 12:30', '', '', '', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-C', ''),
('11:00 - 12:30', 'GEC 103\r\nSoc.Scie. Instructor 4\r\nBSIT1-B', '', 'GEC 103\r\nSoc.Scie. Instructor 4\r\nBSIT1-B', '', ''),
('11:00 - 5:00', '', '', '', '', 'CCJE'),
('1:00 - 2:30', 'GEC 103\r\nSoc.Scie. Instructor 4\r\nBSIT 1-C', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-C', 'GEC 103\r\nSoc.Scie. Instructor 4\r\nBSIT 1-C', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-C', ''),
('2:30 - 4:00', 'GEC 102\r\nMrs. Lucero\r\nBSIS 1-A', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-D', 'GEC 102\r\nMrs. Lucero\r\nBSIS 1-A', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-D', ''),
('4:00 - 5:00', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-B', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-B', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-B', '', ''),
('7:00 - 8:30', '', '', '', 'GEM 301 (PI 100)\r\nSoc.Scie. Instructor 4\r\nBSCS1-A', ''),
('8:00 - 9:30', 'GEC 102\r\nMrs. M. Lucero\r\nBSCS 1-A', '', 'GEC 102\r\nMrs. M. Lucero\r\nBSCS 1-A', '', ''),
('8:30 - 10:00', '', 'BSAB 1-A\r\nMs. Atienza', '', '', ''),
('9:00 - 10:30', '', '', '', 'ITEC 101\r\nMr. Leopando\r\nBSIT 1-C', ''),
('9:30 - 11:00', 'GEC 102\r\nMrs. M. Lucero\r\nBSCS 1-B', '', 'GEC 102\r\nMrs. M. Lucero\r\nBSCS 1-B', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_103`
--

CREATE TABLE `room_103` (
  `Period` varchar(250) NOT NULL,
  `Monday` varchar(250) NOT NULL,
  `Tuesday` varchar(250) NOT NULL,
  `Wednesday` varchar(250) NOT NULL,
  `Thursday` varchar(250) NOT NULL,
  `Friday` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_103`
--

INSERT INTO `room_103` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:30 - 12:00', 'SOCS 221\r\nENGL. Instructor 1\r\nACT 2-C', 'SOCS 221\r\nENGL. Instructor 1\r\nACT 2-C', '', 'GEC 102\r\nSoc.Scie. Instructor 7\r\nBSIT 1-D', ''),
('1:00 - 2:30', 'GEC 101\r\nSoc.Scie. Instructor 3\r\nBSIS 1-A', 'SOSLIT\r\nFilipino Instructor\r\nBSIS 2-A', 'GEC 101\r\nSoc.Scie. Instructor 3\r\nBSIS 1-A', 'SOSLIT\r\nFilipino Instructor\r\nBSIS 2-A', ''),
('2:30 - 4:00', 'GEC 103\r\nSoc.Scie. Instructor 4\r\nBSIT 1-D', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-D', 'GEC 103\r\nSoc.Scie. Instructor 4\r\nBSIT 1-D', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-D', ''),
('4:00 - 5:00', 'CSEL 302\r\nIT-Instructor 1\r\nBSCS 3-A', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIS 1-A', 'GEC 106\r\nMs. Corpuz\r\nBSIS 2-A', 'GEC 106\r\nMs. Corpuz\r\nBSIS 2-A', ''),
('7:00 - 8:00', 'GEC 106\r\nMs. Corpuz\r\nBSIS 1-A', '', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIS 1-A', '', ''),
('7:30 - 9:00', '', 'GEC 104\r\nMs. P. Acero\r\nBSIT 1-C', '', 'GEC 104\r\nMs. P. Acero\r\nBSIT 1-C', ''),
('8:00 - 9:00', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIS 1-A', '', 'GEC 106\r\nMs. Diaz\r\nBSCS 2-A', '', ''),
('9:00 - 10:30', 'MATH 24\r\nMrs. P. Acero\r\nBSCS 2-A', 'SOSLIT\r\nFilipino Instructor\r\nBSCS 2-A', 'MATH 24\r\nMrs. P. Acero\r\nBSCS 2-A', 'SOSLIT\r\nFilipino Instructor\r\nBSCS 2-A', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_106`
--

CREATE TABLE `room_106` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_106`
--

INSERT INTO `room_106` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:30 - 12:00', 'GEC 102\r\nSoc.Scie. Instructor 6\r\nBSIT 1-A', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-B', 'GEC 102\r\nSoc.Scie. Instructor 6\r\nBSIT 1-A', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-B', ''),
('1:00 - 2:30', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-A', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-C', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-A', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-C', ''),
('2:30 - 4:00', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-B', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-A', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-B', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-A', ''),
('4:00 - 5:00', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-D', 'SOSLIT\r\nFilipino Instructor\r\nBSIT 2-C', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-D', 'GEC 107\r\nSoc.Scie. Instructor 5\r\nBSIT 2-D', ''),
('7:30 - 9:00', 'SOCS 3\r\nSoc. Scie Instructor 6\r\nBSIT 3-A', '', 'SOCS 3\r\nSoc. Scie Instructor 6\r\nBSIT 3-A', '', ''),
('9:00 - 10:30', 'GEC  103\r\nSoc.Scie. Mr. Ruzol', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-A', 'GEC  103\r\nSoc.Scie. Mr. Ruzol', 'GEC 101\r\nSoc.Scie. Instructor 1\r\nBSIT 1-A', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_107`
--

CREATE TABLE `room_107` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_107`
--

INSERT INTO `room_107` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:00 - 12:00', '', 'ITEC 102\r\nMR.DE JESUS\r\nBSIS 1-A', '', '', ''),
('12:00 - 2:30', 'Keyboarding\r\nBSOA 1-B', 'AE 21\r\n(IT Application Tools in Business)\r\nMr. J. Diaz\r\nBSACCO 2-A', 'Keyboarding\r\nBSOA 1-B', 'AE 21\r\n(IT Application Tools in Business)\r\nMr. J. Diaz\r\nBSACCO 2-A', ''),
('1:00 - 4:00', '', '', '', '', 'BSAB 1B\r\nMs. Atienza'),
('2:30 - 5:00', 'AE 21\r\n(IT Application Tools in Business)\r\nMr. J. Diaz\r\nBSACCO 2-B', 'ITEC 102\r\nMR.DE JESUS\r\nBSCS 1-A', 'AE 21\r\n(IT Application Tools in Business)\r\nMr. J. Diaz\r\nBSACCO 2-B', 'ITEC 102\r\nMR.DE JESUS\r\nBSIT 1-C', ''),
('4:00 - 5:00', '', '', '', '', 'BSAB 1A\r\nMs. Atienza'),
('7:00 - 9:00', '', '', '', 'ITEC 102\r\nMR.DE JESUS\r\nBSIT 1-D', ''),
('7:00 - 9:30', 'ITEC 102\r\nMR.DE JESUS\r\nBSCS 1-B', 'ITEC 204\r\nMs. Z. Mortel\r\nBSIT 2-B', 'ITEC 102\r\nMR.DE JESUS\r\nBSCS 1-B', '', 'ICT\r\nMr. De Jesus\r\nBSAB 1-C'),
('9:00 - 12:00', '', '', '', 'ITEC 102\r\nMR.DE JESUS\r\nBSIS 1-A', ''),
('9:30 - 10:30', '', '', 'GEM 301 (PI 100)\r\nSoc.Scie. Instructor 4\r\nBSCS 1-A', '', ''),
('9:30 - 12:00', 'ITEC 102\r\nMR.DE JESUS\r\nBSCS 1-A', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_108`
--

CREATE TABLE `room_108` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_108`
--

INSERT INTO `room_108` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:30 - 12:00', 'SHC MIL 12\r\nMedia & Info. Literacy\r\nSenior High Students (ABM12)\r\nMr. R. Diaz', 'ITEC 101\r\nMr. F V Sandoval\r\nBSCS 1-A', 'ITEC 101\r\nMr. F V Sandoval\r\nBSCS 1-A', 'SHA ETECH II\r\n(Empowerment Technologies)\r\nABM 11\r\nMr. F. Urera Jr.', ''),
('1:00 - 2:30', 'SHC MIL 12\r\nMedia & Info. Literacy\r\nSenior High Students\r\n(ABM12)\r\nMr. R. Diaz', 'SHC MIL 12\r\nMedia & Info. Literacy\r\nSenior High Students\r\n(ABM12)\r\nMr. R. Diaz', 'SHC MIL 12\r\nMedia & Info. Literacy\r\nSenior High Students\r\n(ABM12)\r\nMr. R. Diaz', 'SHC MIL 12\r\nMedia & Info. Literacy\r\nSenior High Students\r\n(ABM12)\r\nMr. R. Diaz', ''),
('2:30 - 4:00', 'ITEC 101\r\nMr. R. Diaz\r\nBSIT 1-B', '', 'ITEC 101\r\nMr. R. Diaz\r\nBSIT 1-B', '', ''),
('3:00 - 4:30', '', '', '', 'ITEC 101\r\nMr. Leopando\r\nBSIT 1-A', ''),
('4:00 - 5:00', 'KOMFIL\r\nBSIT I-B\r\nRM 108', '', 'KOMFIL\r\nBSIT I-B\r\nRM 108', '', ''),
('7:30 - 9:00', 'GEC 104\r\nMs. P. Acero\r\nBSIT 1-A', 'SHA ETECH II\r\nEmpowerment Tech (E TECH)\r\nSenior High Students (HUMSS 11)                                                Mr. R. Diaz', 'GEC 104\r\nMs. P. Acero\r\nBSIT 1-A', '', 'SHC MIL 12\r\nMedia & Info. Literacy Senior High Students (ABM12)                                         Mr. R. Diaz'),
('9:00 - 10:30', 'SHA ETECH II\r\n(Empowerment Technologies)\r\nABM 11\r\nMr. F. Urera Jr.', '', 'SHA ETECH II\r\nEmpowerment Tech (E TECH)\r\nSenior High Students (HUMSS 11)\r\nMr. R. Diaz', 'SHA ETECH II\r\nEmpowerment Tech (E TECH)\r\nSenior High Students (HUMSS 11)\r\nMr. R. Diaz', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_201`
--

CREATE TABLE `room_201` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_201`
--

INSERT INTO `room_201` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:00 - 12:00', '', 'ITEL 201\r\nMr. A. De Luna\r\nBSIT 2-A', '', '', ''),
('10:30 - 12:00', 'ISDM 201\r\nMr. F. Urera Jr.\r\nBSIS 2-A', '', '', '', ''),
('11:00 - 12:30', '', '', '', 'CSEL 301\r\nMR.LEOPANDO\r\nBSCS 3-A', ''),
('12:30 - 2:30', '', '', 'ITEL 202\r\nMR. DE JESUS\r\nBSIT 2-D', '', ''),
('1:30 - 2:30', '', '', '', 'ITEL 202\r\nMR.DE JESUS\r\nBSIT 2-D', ''),
('2:30 - 4:00', '', 'ITEP 203\r\nMR.SANTELICES\r\nBSIT 2-C', '', '', ''),
('2:30 - 5:00', 'ICT 1\r\nBSOA 1-B\r\nMR.LEOPANDO', '', 'ICT 1\r\nBSOA 1-B\r\nMR.LEOPANDO', 'ITEC 205\r\nMR.ASTOVEZA\r\nBSIT 2-C', ''),
('4:00 - 5:00', '', 'ITEC 101\r\nMr. R. Diaz\r\nBSIS 1-A', '', '', ''),
('7:00 - 10:00', '', 'CT 224\r\nMr. J. Diaz\r\nACT 2-C', '', '', ''),
('7:00 - 9:00', 'CT 224\r\nMr. J. Diaz\r\nACT 2-C', '', '', '', ''),
('7:30 - 9:00', '', '', 'GEC 104\r\nMr. Gasco\r\nBSIT 1-D', '', ''),
('8:00 - 11:00', '', '', '', '', 'BSAB 1\r\nMR.SANTELICES\r\n(3LAB)'),
('9:00 - 10:30', 'CT 221\r\nMR.LEOPANDO\r\nRM 201', '', '', '', ''),
('9:00 - 11:00', '', '', '', 'BSAB 1\r\nMR.SANTELICES', ''),
('9:00 - 12:00', '', '', 'ITEL 201\r\nMS.ATIENZA\r\nBSIT 2-D', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_202`
--

CREATE TABLE `room_202` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_202`
--

INSERT INTO `room_202` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:30 - 12:00', 'ITEC 101\r\nMr. Leopando\r\nBSIT 1-C', '', '', '', ''),
('12:00 - 2:00', '', 'ITEL 201\r\nMS.ATIENZA\r\nBSIT 2-B', '', '', ''),
('12:00 - 2:30', 'ICT 3\r\n(IMIS & Web Design)\r\nBSOA 2-A\r\nMR.BALAHADIA', '', 'ICT 3\r\n(IMIS & Web Design)\r\nBSOA 2-A\r\nMR.BALAHADIA', '', ''),
('2:00 - 5:00', '', 'AUTO CAD\r\nBS AgEngr\r\nMr. Tuso', '', 'AUTO CAD\r\nBS AgEngr\r\nMr. Tuso', ''),
('2:30 - 5:00', 'ICT 3\r\n(IMIS & Web Design)\r\nBSOA 2-B\r\nMR.SANTELICES', '', 'ICT 3\r\n(IMIS & Web Design)\r\nBSOA 2-B\r\nMR.SANTELICES', '', 'ITEC 205\r\nMR.ASTOVEZA\r\nBSIT 2-C'),
('7:00 - 9:00', '', '', 'ITEC 204\r\nMS.ATIENZA\r\nBSIT2-C', 'ITEP 203\r\nMR.SANTELICES\r\nBSIT 2-D', ''),
('7:00 - 9:30', '', 'ITEL 202\r\nMR.ASTOVEZA\r\nBSIT 2-A', '', '', ''),
('9:00 - 10:00', 'ITEC 101\r\nMs. Z Mortel\r\nBSIT 1-D', '', '', '', ''),
('9:00 - 12:00', '', '', 'ITEL 202\r\nMR.ASTOVEZA\r\nBSIT 2-B', '', ''),
('9:30 - 11:30', '', 'ITEL 202\r\nMR.ASTOVEZA\r\nBSIT 2-B', '', '', ''),
('9:30 - 12:30', '', '', '', 'ITEL 201\r\nMr. A. De Luna\r\nBSIT 2-A', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_203`
--

CREATE TABLE `room_203` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_203`
--

INSERT INTO `room_203` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:00 - 11:00', '', '', '', '', 'FREL 401\r\nBSCS 3-A\r\nMR.ASTOVEZA'),
('10:00 - 11:30', 'ITEP 203\r\nMR. SANTELICES\r\nBSIT 2-B', '', '', '', ''),
('10:30 - 12:00', '', 'ITEC 101\r\nMR.LEOPANDO\r\nBSIT 1-A', '', '', ''),
('12:00 - 2:30', '', '', '', '', 'CMSC 209\r\nMR.SANTELICES\r\nBSCS 3-A'),
('12:30 - 1:30', '', '', '', 'ITEP 203\r\nMR.SANTELICES\r\nBSIT 2-D', ''),
('12:30 - 2:30', 'ITEL 202\r\nMR. DE JESUS\r\nBSIT 2-D', 'ITEP 203\r\nMR.SANTELICES\r\nBSIT 2-A', 'ITEP 311\r\nMR.ASTOVEZA\r\nBSIT 3-A', '', ''),
('1:30 - 2:30', '', '', '', 'ITEP 203\r\nMR.SANTELICES\r\nBSIT 2-A', ''),
('2:30 - 5:00', 'ITEP 309\r\nMr. A. De Luna\r\nBSIT 3-A', 'ITEP 309\r\nMr. A. De Luna\r\nBSIT 3-A', 'ITEC 204\r\nMS.ATIENZA\r\nBSIT 2-A\r\n', 'ITEP 312\r\nMR.SANTELICES\r\nBSIT 3-A', 'CMSC 209\r\nMR.SANTELICES\r\nBSCS 3-A'),
('7:00 - 10:00', '', '', '', '', 'CMSC 210\r\nMR.ASTOVEZA\r\nBSCS 3-A'),
('7:00 - 9:00', 'FREL 401\r\nBSCS 3-A\r\nN.ASTOVEZA', '', 'ITEP 203\r\nMR.SANTELICES\r\nBSIT 2-B', '', ''),
('7:00 - 9:30', '', 'ITEP 309\r\nMr. A. De Luna\r\nBSIT 3-A', '', 'ITEP 310\r\nMr. A. De Luna\r\nBSIT 3-A', ''),
('9:00 - 11:30', '', '', 'ITEP 312\r\nMR.SANTELICES\r\nBSIT 3-A', '', ''),
('9:30 - 12:30', '', '', '', 'ITEP 311\r\nMR.ASTOVEZA\r\nBSIT 3-A', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_204`
--

CREATE TABLE `room_204` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_204`
--

INSERT INTO `room_204` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:30 - 12:00', '', '', 'ITEC 204\r\nMs. Z.J MORTEL\r\nBSCS 2-A', '', ''),
('11:00 - 2:30', '', 'ITEC 104\r\n(Data Structures and Algorithm)\r\nMs. Z.J Mortel\r\nBSCS 2-A', '', '', ''),
('12:00 - 2:30', 'ITEC 204\r\nMs. Z.J Mortel\r\nBSIT 2-B', '', '', '', ''),
('12:30 - 2:30', '', '', 'ITEC 101\r\nMs. Z.J Mortel\r\nBSIT 1-D', '', ''),
('1:00 - 5:00', '', '', '', '', 'CMSC 203\r\nMr. F. Balahadia\r\nBSCS 1-A'),
('2:30 - 5:00', 'ITEC 102\r\nMs. Z.J Mortel\r\nBSIT 1-A', 'BSAB 1A\r\nMS.ATIENZA', 'ITEC 102\r\nMs. Z.J Mortel\r\nBSIT 1-A', '', ''),
('7:00 - 10:00', '', 'ITEC 102\r\nMr. DE JESUS\r\nBSIT 1-D', '', '', 'CMSC 202\r\nMS.Z.MORTEL\r\nBSCS 2-A'),
('7:00 - 9:00', 'ITEC 204 (LEC)\r\nMs. A.R ATIENZA\r\nBSIT 2-D', '', '', '', ''),
('7:30 - 10:30', '', '', '', 'ITEC 204\r\nMs. A.R ATIENZA\r\nBSIT 2-C', ''),
('8:00 - 9:30', '', '', 'MIS\r\nMr. DE LUNA\r\nBSHRM', '', ''),
('9:00 - 12:00', 'ITEC 204(LAB)\r\nMs. A.R ATIENZA\r\nBSIT 2-D', '', '', '', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_205`
--

CREATE TABLE `room_205` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_205`
--

INSERT INTO `room_205` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('12:30 - 2:30', '', '', '', '', 'ITEL 202\r\nMr. R.Diaz'),
('1:00 - 2:30', 'ENGL 311\r\nBSCS 3-A', '', '', '', ''),
('2:30 - 4:00', 'LIT 2\r\nBSCS 3-A', '', '', '', ''),
('4:00 - 5:00', '', 'ITEC 205\r\nN.ASTOVEZA\r\nBSIT\r\n2-D', '', '', ''),
('7:00 - 9:00', '', '', 'ITEC 205\r\nMr. Balahadia\r\nBSIT 2-A', '', ''),
('8:00 - 9:00', 'MIS\r\nMr. De  Luna \r\nBSHRM B', '', '', '', ''),
('9:00 - 12:00', '', 'MIS\r\nBSOA\r\nMr.R.Diaz', '', '', 'ITEL 202\r\nMr.R.Diaz'),
('9:30 - 11:00', '', '', '', 'LIT 2\r\nBSCS 3-A', '');

-- --------------------------------------------------------

--
-- Table structure for table `room_206`
--

CREATE TABLE `room_206` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_206`
--

INSERT INTO `room_206` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:00 - 11:30', '', '', 'MIS\r\nMr. DE LUNA\r\nBSHRM A', '', ''),
('10:00 - 12:00', '', '', '', 'MIL ABM (12)\r\nMr. R. Diaz', ''),
('11:30 - 2:00', '', '', '', '', 'ICT 1\r\nMR.LEOPANDO\r\nBSOA 1-A'),
('12:00 - 2:00', '', 'ITEC 205\r\nMR. ASTOVEZA\r\nBSIT 2-D', '', '', ''),
('12:30 - 2:30', 'BSAB 1B\r\nMs. ATIENZA', '', '', '', ''),
('2:30 - 4:30', '', '', '', 'CSEL 302\r\nMR. R. DIAZ\r\nBSCS 3-A', ''),
('2:30 - 5:00', 'ITEC 204\r\nMs. ATIENZA\r\nBSIT 2-A', 'ITEC 102\r\nMs. Z. Mortel\r\nBSIT 1-B', 'ITEC 102\r\nMr. DE JESUS\r\nBSIT 1-C', '', 'ICT 1\r\nMR.LEOPANDO\r\nBSOA 1-A'),
('7:00 - 10:00', '', '', 'Keyboarding\r\nBSOA 1-C', '', ''),
('7:00 - 9:30', '', 'ICT 1\r\nN.SANTELICES\r\nBSOA 1-C', '', 'ITEC 102\r\nMs. Z. Mortel\r\nBSIT 1-B', ''),
('7:30 - 10:00', 'ICT\r\nMR.SANTELICES\r\nBSOA 1-C', '', '', '', ''),
('9:30 - 11:30', '', 'ITEL 201\r\nMs. ATIENZA\r\nBSIT 2-D', '', '', 'Keyboarding\r\nBSOA 1-C');

-- --------------------------------------------------------

--
-- Table structure for table `room_207`
--

CREATE TABLE `room_207` (
  `Period` varchar(255) NOT NULL,
  `Monday` varchar(255) NOT NULL,
  `Tuesday` varchar(255) NOT NULL,
  `Wednesday` varchar(255) NOT NULL,
  `Thursday` varchar(255) NOT NULL,
  `Friday` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `room_207`
--

INSERT INTO `room_207` (`Period`, `Monday`, `Tuesday`, `Wednesday`, `Thursday`, `Friday`) VALUES
('10:00 - 11:00', 'MIS\r\nBSHRM A\r\nMr.De Luna', '', '', '', ''),
('12:00 - 2:30', '', '', 'ITEP 203\r\nMr. SANTELICES\r\nBSIT 2-C', '', ''),
('12:00 - 3:00', 'ITEC 105\r\n(Information Management)\r\nMr. N.E. Astoveza\r\nBSCS 2-A', '', '', '', ''),
('12:30 - 3:30', '', 'CT 222\r\nMr. F. Urera Jr.\r\nRM 203\r\nACT 2-C', '', '', ''),
('2:00 - 5:00', '', '', '', 'ITEL 201\r\nMs. A.R ATIENZA\r\nBSIT 2-B', ''),
('3:00 - 5:00', 'CT 222\r\nMr. F. Urera Jr.\r\nACT 2-C', '', 'ITEC 105\r\n(Information Management)\r\nMr. N.E. Astoveza\r\nBSCS 2-A', '', ''),
('3:30 - 5:00', '', 'CT 221\r\nMr. R. Leopando\r\nACT 2A', '', '', ''),
('7:00 - 11:00', '', 'ITEC 105\r\nMr. F. Balahadia\r\nBSIS 2-A', '', '', ''),
('7:00 - 9:00', 'ITEC 205\r\nMr. F. Balahadia\r\nBSIT 2-B', '', 'ITEC 205\r\nMR. ASTOVEZA\r\nBSIT  2-D', '', ''),
('7:00 - 9:30', '', '', '', 'ITEL 202\r\nMR.ASTOVEZA\r\nBSIT 2-A', ''),
('9:00 - 10:00', 'ITEC 105\r\nMr. F. Balahadia\r\nBSIS 2-A', '', '', '', ''),
('9:00 - 12:00', '', '', 'ITEC 205\r\nMr. Balahadia\r\nBSIT 2-A', '', ''),
('9:30 - 12:30', '', '', '', 'ITEC 205\r\nMr. F. Balahadia\r\nBSIT 2-B', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `old_hs_lib`
--
ALTER TABLE `old_hs_lib`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_101`
--
ALTER TABLE `room_101`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_102`
--
ALTER TABLE `room_102`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_103`
--
ALTER TABLE `room_103`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_106`
--
ALTER TABLE `room_106`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_107`
--
ALTER TABLE `room_107`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_108`
--
ALTER TABLE `room_108`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_201`
--
ALTER TABLE `room_201`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_202`
--
ALTER TABLE `room_202`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_203`
--
ALTER TABLE `room_203`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_204`
--
ALTER TABLE `room_204`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_205`
--
ALTER TABLE `room_205`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_206`
--
ALTER TABLE `room_206`
  ADD PRIMARY KEY (`Period`);

--
-- Indexes for table `room_207`
--
ALTER TABLE `room_207`
  ADD PRIMARY KEY (`Period`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
