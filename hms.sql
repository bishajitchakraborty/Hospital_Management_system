-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 26, 2020 at 05:05 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hms`
--

-- --------------------------------------------------------

--
-- Table structure for table `appointmentpatient`
--

CREATE TABLE `appointmentpatient` (
  `Doctor Name` varchar(25) NOT NULL,
  `SN` varchar(255) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `Fees` int(5) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `appointmentpatient`
--

INSERT INTO `appointmentpatient` (`Doctor Name`, `SN`, `Name`, `Fees`, `Time`) VALUES
('Dr Koushike', '1', 'fght', 500, '2020-09-03 18:00:00'),
('Dr shubarna', '2', 'Tamanna Akter', 500, '2020-09-11 18:00:00');

-- --------------------------------------------------------

--
-- Table structure for table `doctor_info`
--

CREATE TABLE `doctor_info` (
  `License_No` bigint(20) NOT NULL,
  `Name` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `doctor_infor`
--

CREATE TABLE `doctor_infor` (
  `License_No` varchar(255) NOT NULL,
  `Name` varchar(25) NOT NULL,
  `specialization` varchar(20) NOT NULL,
  `qualification` varchar(10) NOT NULL,
  `room_no` int(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `doctor_infor`
--

INSERT INTO `doctor_infor` (`License_No`, `Name`, `specialization`, `qualification`, `room_no`) VALUES
('007', 'Dr Nupur Kor', 'Heart', 'FCBS', 1007),
('1001', 'Dr Bishajit', 'Medecine', 'MBBS', 101),
('1002', 'Dr pulack', 'Sexologist', 'MBBS', 102),
('1003', 'Dr Koushike', 'TNT', 'MBBS', 103),
('1004', 'Dr Rakibul', 'Heart', 'MBBS', 104),
('1005', 'Dr shubarna', 'Medicine', 'MBBS', 105),
('1006', 'Dr Kapil', 'Medicine', 'MBBS', 106),
('LN0007', 'Dr Samir', 'ALl', 'PMD', 109),
('LN0008', 'Dr  Imam Hossain', 'Neorologist', 'MBBS', 110),
('LN0009', 'Dr Maruf', 'TNT', 'FCBS', 110);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `ID` int(11) NOT NULL,
  `Username` varchar(25) NOT NULL,
  `Password` varchar(15) NOT NULL,
  `Usertype` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`ID`, `Username`, `Password`, `Usertype`) VALUES
(1, 'bishajit', '1234', 'student');

-- --------------------------------------------------------

--
-- Table structure for table `patient_info`
--

CREATE TABLE `patient_info` (
  `ID` varchar(255) NOT NULL,
  `patientname` varchar(20) NOT NULL,
  `fathername` varchar(20) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `age` int(5) NOT NULL,
  `phonenumber` varchar(13) NOT NULL,
  `dathofbirth` date NOT NULL,
  `advisor` varchar(25) NOT NULL,
  `diseasehistory` varchar(200) NOT NULL,
  `discription` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `patient_info`
--

INSERT INTO `patient_info` (`ID`, `patientname`, `fathername`, `gender`, `age`, `phonenumber`, `dathofbirth`, `advisor`, `diseasehistory`, `discription`) VALUES
('1', 'Mukta', 'Urtam Kumer', 'Female', 22, '98765789', '2020-09-03', 'Dr shubarna', 'Normal', 'Etorix'),
('101', 'Pranto', 'BenuBoshon', 'Male', 20, '98706543', '0000-00-00', 'Dr Rakibul', 'Normal', 'sergel'),
('102', 'fghki', 'ghyju', 'tju', 32, '5678', '2020-09-04', 'Dr Nupur Kor', 'ertyui', 'fgrtyuji'),
('PN003', 'efrgj', 'ghjk', 'jk', 45, '5678965', '2020-09-12', 'Dr  Imam Hossain', 'eryjuk', 'fgh'),
('PN004', 'Dipto', 'Poritous', 'Male', 5, '345678', '2020-09-05', 'Dr Bishajit', 'Normal', 'Serjal40'),
('PN005', 'Ovi ', 'Rajib', 'Male', 24, '879654', '2020-09-02', 'Dr Maruf', 'Normal', 'VGtgifjhboi');

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `username` varchar(20) NOT NULL,
  `password` varchar(15) NOT NULL,
  `confarmpassword` varchar(15) NOT NULL,
  `usertype` varchar(15) NOT NULL,
  `gender` varchar(8) NOT NULL,
  `age` int(4) NOT NULL,
  `phonenumber` varchar(14) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`username`, `password`, `confarmpassword`, `usertype`, `gender`, `age`, `phonenumber`) VALUES
('bishajit', '12345', '12345', 'admin', 'male', 23, '234567');

-- --------------------------------------------------------

--
-- Table structure for table `signup1`
--

CREATE TABLE `signup1` (
  `usernumber` int(11) NOT NULL,
  `password` varchar(10) NOT NULL,
  `compossword` varchar(10) NOT NULL,
  `usertype` varchar(15) NOT NULL,
  `gender` varchar(7) NOT NULL,
  `age` varchar(5) NOT NULL,
  `phonenumber` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `testslist`
--

CREATE TABLE `testslist` (
  `Test Type` varchar(15) NOT NULL,
  `Test Name` varchar(10) NOT NULL,
  `Price` varchar(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `testslist`
--

INSERT INTO `testslist` (`Test Type`, `Test Name`, `Price`) VALUES
('BloodAnalysis', 'Bloodcount', '500'),
('Angiograpy', 'angiograpy', '1500'),
('Blood', 'RBC', '100'),
('Imaging', 'X_Ray', '500'),
('Blood', 'Hematocrit', '1000'),
('', '', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `appointmentpatient`
--
ALTER TABLE `appointmentpatient`
  ADD PRIMARY KEY (`SN`);

--
-- Indexes for table `doctor_info`
--
ALTER TABLE `doctor_info`
  ADD PRIMARY KEY (`License_No`);

--
-- Indexes for table `doctor_infor`
--
ALTER TABLE `doctor_infor`
  ADD PRIMARY KEY (`License_No`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `patient_info`
--
ALTER TABLE `patient_info`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `signup1`
--
ALTER TABLE `signup1`
  ADD PRIMARY KEY (`usernumber`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `doctor_info`
--
ALTER TABLE `doctor_info`
  MODIFY `License_No` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `signup1`
--
ALTER TABLE `signup1`
  MODIFY `usernumber` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
