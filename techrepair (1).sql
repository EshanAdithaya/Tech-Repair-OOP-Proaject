-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 05, 2024 at 07:53 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `techrepair`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE `customers` (
  `CustomerID` int(11) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `Password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`CustomerID`, `FirstName`, `LastName`, `Email`, `Phone`, `Address`, `Password`) VALUES
(1, '1', '1', '1', '1', '1', ''),
(3, '2', '2', '2', '2', '2', 'jPasswordField1'),
(4, 'e', 'e', 'e', 'e', 'e', 'e');

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `EmployeeID` int(11) NOT NULL,
  `EmployeeFname` varchar(100) NOT NULL,
  `EmployeeLname` varchar(100) NOT NULL,
  `EmployeeEmail` varchar(100) NOT NULL,
  `EmployeePhone` varchar(15) NOT NULL,
  `EmployeeJobRole` varchar(50) NOT NULL,
  `EmployeeWorkLocation` varchar(50) NOT NULL,
  `EmployeeStatus` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`EmployeeID`, `EmployeeFname`, `EmployeeLname`, `EmployeeEmail`, `EmployeePhone`, `EmployeeJobRole`, `EmployeeWorkLocation`, `EmployeeStatus`) VALUES
(1, '123', '123', '123', '123', 'Technician', 'Office', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `inventory`
--

CREATE TABLE `inventory` (
  `ItemID` int(255) NOT NULL,
  `ItemName` varchar(100) NOT NULL,
  `Description` varchar(255) DEFAULT NULL,
  `Category` varchar(100) NOT NULL,
  `Stock` varchar(20) NOT NULL,
  `UnitPrice` varchar(20) NOT NULL,
  `SupplierName` varchar(100) DEFAULT NULL,
  `SKU` varchar(50) DEFAULT NULL,
  `WarehouseLocation` varchar(100) DEFAULT NULL,
  `Status` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `inventory`
--

INSERT INTO `inventory` (`ItemID`, `ItemName`, `Description`, `Category`, `Stock`, `UnitPrice`, `SupplierName`, `SKU`, `WarehouseLocation`, `Status`) VALUES
(1, '123', '123', 'Motherboards', '123', '123', '123', '12', '123', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `notifications`
--

CREATE TABLE `notifications` (
  `NotificationID` int(11) NOT NULL,
  `RecipientType` enum('Customer','Employee') NOT NULL,
  `RecipientID` int(11) NOT NULL,
  `Message` text NOT NULL,
  `SentDate` datetime DEFAULT current_timestamp(),
  `Status` enum('Sent','Delivered','Read') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `OrderID` int(11) NOT NULL,
  `CustomerName` varchar(255) DEFAULT NULL,
  `CustomerPhoneNumber` varchar(20) DEFAULT NULL,
  `OrderDate` datetime DEFAULT current_timestamp(),
  `ServiceType` varchar(255) NOT NULL,
  `TotalAmount` varchar(255) DEFAULT NULL,
  `DeviceType` varchar(255) DEFAULT NULL,
  `IssueDescription` varchar(255) DEFAULT NULL,
  `Status` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`OrderID`, `CustomerName`, `CustomerPhoneNumber`, `OrderDate`, `ServiceType`, `TotalAmount`, `DeviceType`, `IssueDescription`, `Status`) VALUES
(1, '1', '1', '2024-09-05 21:16:31', 'Repair', '1.00', '1', '1', 'Pending'),
(2, '1', '1', '2024-09-05 21:16:48', 'Repair', '1.00', '1', '1', 'Pending'),
(3, '1', '1', '2024-09-05 21:20:04', 'Repair', '1.00', '1', '1', 'Pending'),
(4, '1', '1', '2024-09-05 21:21:16', 'Repair', '1.00', '1', '1', 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `suppliers`
--

CREATE TABLE `suppliers` (
  `SupplierID` int(11) NOT NULL,
  `CompanyName` varchar(100) NOT NULL,
  `ContactName` varchar(100) DEFAULT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `Street_Address` varchar(255) DEFAULT NULL,
  `City` varchar(255) NOT NULL,
  `State/Province` varchar(255) NOT NULL,
  `Postal_Code` varchar(255) NOT NULL,
  `Country` varchar(255) NOT NULL,
  `Main_Product/Service_Category` varchar(255) NOT NULL,
  `Active/Inactive` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `suppliers`
--

INSERT INTO `suppliers` (`SupplierID`, `CompanyName`, `ContactName`, `Email`, `Phone`, `Street_Address`, `City`, `State/Province`, `Postal_Code`, `Country`, `Main_Product/Service_Category`, `Active/Inactive`) VALUES
(1, '123', '123', '123', '123', '123', '123', '123', '123', '123', 'Main Product', 'Active');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers`
--
ALTER TABLE `customers`
  ADD PRIMARY KEY (`CustomerID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`EmployeeID`);

--
-- Indexes for table `inventory`
--
ALTER TABLE `inventory`
  ADD PRIMARY KEY (`ItemID`),
  ADD UNIQUE KEY `SKU` (`SKU`);

--
-- Indexes for table `notifications`
--
ALTER TABLE `notifications`
  ADD PRIMARY KEY (`NotificationID`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`OrderID`);

--
-- Indexes for table `suppliers`
--
ALTER TABLE `suppliers`
  ADD PRIMARY KEY (`SupplierID`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customers`
--
ALTER TABLE `customers`
  MODIFY `CustomerID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `EmployeeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `inventory`
--
ALTER TABLE `inventory`
  MODIFY `ItemID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `notifications`
--
ALTER TABLE `notifications`
  MODIFY `NotificationID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `OrderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `suppliers`
--
ALTER TABLE `suppliers`
  MODIFY `SupplierID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
