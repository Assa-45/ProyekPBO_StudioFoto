-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 06, 2025 at 10:26 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `studio_photo`
--

-- --------------------------------------------------------

--
-- Table structure for table `operator`
--

CREATE TABLE `operator` (
  `id_operator` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `nama_lengkap` varchar(100) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `operator`
--

INSERT INTO `operator` (`id_operator`, `username`, `password`, `nama_lengkap`, `email`) VALUES
(1, 'robert', '123', 'Robert De Vinci', 'robertdevinci@gmail.com'),
(2, 'vanya', '112', 'Vanya Kamila', 'kamilavanya@gmail.com'),
(3, 'salasa', '12345', 'kurniasari salasa', 'kurniasari@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `reservasi`
--

CREATE TABLE `reservasi` (
  `id_reservasi` int(11) NOT NULL,
  `tanggal` date NOT NULL,
  `jam_mulai` time NOT NULL,
  `durasi_jam` int(11) NOT NULL,
  `total_harga` double NOT NULL,
  `jam_selesai` time DEFAULT NULL,
  `nama_customer` varchar(100) NOT NULL,
  `nomor_hp_customer` varchar(15) NOT NULL,
  `tipe_studio` varchar(50) NOT NULL,
  `harga_per_jam` double NOT NULL,
  `status` enum('ONGOING','DONE','CANCEL') NOT NULL DEFAULT 'ONGOING'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `reservasi`
--

INSERT INTO `reservasi` (`id_reservasi`, `tanggal`, `jam_mulai`, `durasi_jam`, `total_harga`, `jam_selesai`, `nama_customer`, `nomor_hp_customer`, `tipe_studio`, `harga_per_jam`, `status`) VALUES
(1, '2025-06-02', '14:00:00', 2, 150000, '16:00:00', 'Salma', '085678123345', 'Small', 75000, 'ONGOING'),
(2, '2025-06-03', '10:00:00', 1, 100000, '11:00:00', 'Sally', '085678912456', 'Medium', 100000, 'ONGOING'),
(3, '2025-06-11', '11:26:00', 1, 100000, '12:26:00', 'Nana', '8678623', 'Medium', 100000, 'ONGOING');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `operator`
--
ALTER TABLE `operator`
  ADD PRIMARY KEY (`id_operator`);

--
-- Indexes for table `reservasi`
--
ALTER TABLE `reservasi`
  ADD PRIMARY KEY (`id_reservasi`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `operator`
--
ALTER TABLE `operator`
  MODIFY `id_operator` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `reservasi`
--
ALTER TABLE `reservasi`
  MODIFY `id_reservasi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
