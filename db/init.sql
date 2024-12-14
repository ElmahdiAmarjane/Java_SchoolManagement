-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mer. 11 déc. 2024 à 15:35
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `absence`
--

CREATE TABLE `absence` (
  `id` int(11) NOT NULL,
  `etudiants` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL CHECK (json_valid(`etudiants`)),
  `date` date NOT NULL,
  `heure_debut` time NOT NULL,
  `heure_fine` time NOT NULL,
  `id_filier` varchar(255) NOT NULL,
  `element_nom` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `absence`
--

INSERT INTO `absence` (`id`, `etudiants`, `date`, `heure_debut`, `heure_fine`, `id_filier`, `element_nom`) VALUES
(22, '[\"D1343333\",\"D1343333sd\"]', '2024-12-04', '08:00:00', '10:00:00', 'IL', 'JAVA'),
(24, '[\"D1343333\",\"D1343333sd\"]', '2024-12-04', '14:00:00', '16:00:00', 'IL', 'RASEAUX'),
(27, '[\"D134\"]', '2024-12-04', '08:00:00', '10:00:00', 'DATA', 'RASEAUX'),
(29, '[]', '2024-12-05', '08:00:00', '10:00:00', 'IL', 'JAVA'),
(31, '[\"D134\",\"D1343333s\"]', '2024-12-05', '08:00:00', '10:00:00', 'IL', 'RASEAUX'),
(32, '[\"D134\",\"D1343333sd\"]', '2024-12-11', '08:00:00', '10:00:00', 'DATA', 'JAVA');

-- --------------------------------------------------------

--
-- Structure de la table `annonce`
--

CREATE TABLE `annonce` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `contenu` text NOT NULL,
  `file` varchar(255) DEFAULT NULL,
  `dateAnnonce` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `annonce`
--

INSERT INTO `annonce` (`id`, `title`, `contenu`, `file`, `dateAnnonce`) VALUES
(15, 'dd', 'ddd', NULL, '2024-12-01 18:49:31'),
(16, 'hi', 'hello', NULL, '2024-12-01 19:07:59'),
(17, 'yyyyyyyyttt', 'tttt', NULL, '2024-12-01 19:37:48');

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `files` text DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `filier_titel` varchar(255) DEFAULT NULL,
  `element_id` varchar(255) DEFAULT NULL,
  `datePublication` datetime DEFAULT current_timestamp(),
  `date_limit` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `course`
--

INSERT INTO `course` (`id`, `title`, `description`, `files`, `type`, `filier_titel`, `element_id`, `datePublication`, `date_limit`) VALUES
(12, '', '', '', NULL, NULL, NULL, '2024-12-04 00:00:00', NULL),
(13, '', '', '', 'TD/TP', 'IL', 'JAVA', '2024-12-04 00:00:00', '2024-12-04'),
(14, 'Hello', 'HHHHH', '', 'TD/TP', 'IL', 'JAVA', '2024-12-04 00:00:00', '2024-12-20');

-- --------------------------------------------------------

--
-- Structure de la table `element`
--

CREATE TABLE `element` (
  `id` int(11) NOT NULL,
  `nom` varchar(250) NOT NULL,
  `filier_titel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `element`
--

INSERT INTO `element` (`id`, `nom`, `filier_titel`) VALUES
(6, 'JAVA', 'DATA'),
(7, 'RASEAUX', 'Ingoniere Logiciele');

-- --------------------------------------------------------

--
-- Structure de la table `emploi`
--

CREATE TABLE `emploi` (
  `id` int(11) NOT NULL,
  `date` date NOT NULL,
  `8-10-element-lundi` varchar(255) DEFAULT NULL,
  `10-12-element-lundi` varchar(255) DEFAULT NULL,
  `2-4-element-lundi` varchar(255) DEFAULT NULL,
  `4-6-element-lundi` varchar(255) DEFAULT NULL,
  `cni_user` longtext DEFAULT NULL,
  `filier_titel` varchar(255) DEFAULT NULL,
  `8-10-prof-lundi` varchar(255) DEFAULT NULL,
  `10-12-prof-lundi` varchar(255) DEFAULT NULL,
  `2-4-prof-lundi` varchar(255) DEFAULT NULL,
  `4-6-prof-lundi` varchar(255) DEFAULT NULL,
  `8-10-salle-lundi` varchar(255) DEFAULT NULL,
  `10-12-salle-lundi` varchar(255) DEFAULT NULL,
  `2-4-salle-lundi` varchar(255) DEFAULT NULL,
  `4-6-salle-lundi` varchar(255) DEFAULT NULL,
  `8-10-element-mardi` varchar(255) DEFAULT NULL,
  `10-12-element-mardi` varchar(255) DEFAULT NULL,
  `2-4-element-mardi` varchar(255) DEFAULT NULL,
  `4-6-element-mardi` varchar(255) DEFAULT NULL,
  `8-10-prof-mardi` varchar(255) DEFAULT NULL,
  `10-12-prof-mardi` varchar(255) DEFAULT NULL,
  `2-4-prof-mardi` varchar(255) DEFAULT NULL,
  `4-6-prof-mardi` varchar(255) DEFAULT NULL,
  `8-10-salle-mardi` varchar(255) DEFAULT NULL,
  `10-12-salle-mardi` varchar(255) DEFAULT NULL,
  `2-4-salle-mardi` varchar(255) DEFAULT NULL,
  `4-6-salle-mardi` varchar(255) DEFAULT NULL,
  `8-10-element-mercredi` varchar(255) DEFAULT NULL,
  `10-12-element-mercredi` varchar(255) DEFAULT NULL,
  `2-4-element-mercredi` varchar(255) DEFAULT NULL,
  `4-6-element-mercredi` varchar(255) DEFAULT NULL,
  `8-10-prof-mercredi` varchar(255) DEFAULT NULL,
  `10-12-prof-mercredi` varchar(255) DEFAULT NULL,
  `2-4-prof-mercredi` varchar(255) DEFAULT NULL,
  `4-6-prof-mercredi` varchar(255) DEFAULT NULL,
  `8-10-salle-mercredi` varchar(255) DEFAULT NULL,
  `10-12-salle-mercredi` varchar(255) DEFAULT NULL,
  `2-4-salle-mercredi` varchar(255) DEFAULT NULL,
  `4-6-salle-mercredi` varchar(255) DEFAULT NULL,
  `8-10-element-jeudi` varchar(255) DEFAULT NULL,
  `10-12-element-jeudi` varchar(255) DEFAULT NULL,
  `2-4-element-jeudi` varchar(255) DEFAULT NULL,
  `4-6-element-jeudi` varchar(255) DEFAULT NULL,
  `8-10-prof-jeudi` varchar(255) DEFAULT NULL,
  `10-12-prof-jeudi` varchar(255) DEFAULT NULL,
  `2-4-prof-jeudi` varchar(255) DEFAULT NULL,
  `4-6-prof-jeudi` varchar(255) DEFAULT NULL,
  `8-10-salle-jeudi` varchar(255) DEFAULT NULL,
  `10-12-salle-jeudi` varchar(255) DEFAULT NULL,
  `2-4-salle-jeudi` varchar(255) DEFAULT NULL,
  `4-6-salle-jeudi` varchar(255) DEFAULT NULL,
  `8-10-element-vendredi` varchar(255) DEFAULT NULL,
  `10-12-element-vendredi` varchar(255) DEFAULT NULL,
  `2-4-element-vendredi` varchar(255) DEFAULT NULL,
  `4-6-element-vendredi` varchar(255) DEFAULT NULL,
  `8-10-prof-vendredi` varchar(255) DEFAULT NULL,
  `10-12-prof-vendredi` varchar(255) DEFAULT NULL,
  `2-4-prof-vendredi` varchar(255) DEFAULT NULL,
  `4-6-prof-vendredi` varchar(255) DEFAULT NULL,
  `8-10-salle-vendredi` varchar(255) DEFAULT NULL,
  `10-12-salle-vendredi` varchar(255) DEFAULT NULL,
  `2-4-salle-vendredi` varchar(255) DEFAULT NULL,
  `4-6-salle-vendredi` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `emploi`
--

INSERT INTO `emploi` (`id`, `date`, `8-10-element-lundi`, `10-12-element-lundi`, `2-4-element-lundi`, `4-6-element-lundi`, `cni_user`, `filier_titel`, `8-10-prof-lundi`, `10-12-prof-lundi`, `2-4-prof-lundi`, `4-6-prof-lundi`, `8-10-salle-lundi`, `10-12-salle-lundi`, `2-4-salle-lundi`, `4-6-salle-lundi`, `8-10-element-mardi`, `10-12-element-mardi`, `2-4-element-mardi`, `4-6-element-mardi`, `8-10-prof-mardi`, `10-12-prof-mardi`, `2-4-prof-mardi`, `4-6-prof-mardi`, `8-10-salle-mardi`, `10-12-salle-mardi`, `2-4-salle-mardi`, `4-6-salle-mardi`, `8-10-element-mercredi`, `10-12-element-mercredi`, `2-4-element-mercredi`, `4-6-element-mercredi`, `8-10-prof-mercredi`, `10-12-prof-mercredi`, `2-4-prof-mercredi`, `4-6-prof-mercredi`, `8-10-salle-mercredi`, `10-12-salle-mercredi`, `2-4-salle-mercredi`, `4-6-salle-mercredi`, `8-10-element-jeudi`, `10-12-element-jeudi`, `2-4-element-jeudi`, `4-6-element-jeudi`, `8-10-prof-jeudi`, `10-12-prof-jeudi`, `2-4-prof-jeudi`, `4-6-prof-jeudi`, `8-10-salle-jeudi`, `10-12-salle-jeudi`, `2-4-salle-jeudi`, `4-6-salle-jeudi`, `8-10-element-vendredi`, `10-12-element-vendredi`, `2-4-element-vendredi`, `4-6-element-vendredi`, `8-10-prof-vendredi`, `10-12-prof-vendredi`, `2-4-prof-vendredi`, `4-6-prof-vendredi`, `8-10-salle-vendredi`, `10-12-salle-vendredi`, `2-4-salle-vendredi`, `4-6-salle-vendredi`) VALUES
(16, '2024-12-10', '[\"JAVA ( CM )\"]', '[\"JAVA ( CM )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', 'SAMIR abakarim', NULL, '[]', '[]', '[]', '[]', '[\"Salle 1\"]', '[\"Salle 1\"]', '[null]', '[null]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[]', '[]', '[]', '[]', '[null]', '[null]', '[null]', '[null]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[]', '[]', '[]', '[]', '[null]', '[null]', '[null]', '[null]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[]', '[]', '[]', '[]', '[null]', '[null]', '[null]', '[null]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[\"null ( null )\"]', '[]', '[]', '[]', '[]', '[null]', '[null]', '[null]', '[null]');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `cne` varchar(30) NOT NULL,
  `type_bac` varchar(255) NOT NULL,
  `note_bac` double NOT NULL,
  `type_bac2` varchar(255) NOT NULL,
  `note_bac2` double NOT NULL,
  `titel_filier` varchar(255) NOT NULL,
  `cni_user` varchar(30) NOT NULL,
  `imageBac` text NOT NULL,
  `imageBac2` text NOT NULL,
  `imageS1` text NOT NULL,
  `imageS2` text NOT NULL,
  `imageS3` text NOT NULL,
  `imageS4` text NOT NULL,
  `anneeBac` int(11) NOT NULL,
  `universityBac2` varchar(255) NOT NULL,
  `etablismentBac2` varchar(255) NOT NULL,
  `noteS1` double NOT NULL,
  `noteS2` double NOT NULL,
  `noteS3` double NOT NULL,
  `noteS4` double NOT NULL,
  `anneeS1` int(11) NOT NULL,
  `anneeS2` int(11) NOT NULL,
  `anneeS3` int(11) NOT NULL,
  `anneeS4` int(11) NOT NULL,
  `relverBac` text NOT NULL,
  `bac_acadimie` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`cne`, `type_bac`, `note_bac`, `type_bac2`, `note_bac2`, `titel_filier`, `cni_user`, `imageBac`, `imageBac2`, `imageS1`, `imageS2`, `imageS3`, `imageS4`, `anneeBac`, `universityBac2`, `etablismentBac2`, `noteS1`, `noteS2`, `noteS3`, `noteS4`, `anneeS1`, `anneeS2`, `anneeS3`, `anneeS4`, `relverBac`, `bac_acadimie`) VALUES
('D134', 'Mohamed', 10, 'Mohamed', 10, 'IL', 'D134', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 2024, 'Mohamed', 'Mohamed', 10, 10, 10, 10, 2024, 2024, 2024, 2024, 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Mohamed'),
('D1343333', 'Mohamed', 10, 'Mohamed', 10, 'IL', 'D13433', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 2024, 'Mohamed', 'Mohamed', 10, 10, 10, 10, 2024, 2024, 2024, 2024, 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Mohamed'),
('D1343333s', 'Mohamed', 10, 'Mohamed', 10, 'IL', 'D13433s', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 2024, 'Mohamed', 'Mohamed', 10, 10, 10, 10, 2024, 2024, 2024, 2024, 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Mohamed'),
('D1343333sd', 'Mohamed', 10, 'Mohamed', 10, 'DATA', 'D13433sd', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 2024, 'Mohamed', 'Mohamed', 10, 10, 10, 10, 2024, 2024, 2024, 2024, 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Mohamed'),
('D1343333sdx', 'Mohamed', 10, 'Mohamed', 10, 'DATA', 'D13433sdx', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 2024, 'Mohamed', 'Mohamed', 10, 10, 10, 10, 2024, 2024, 2024, 2024, 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Mohamed');

-- --------------------------------------------------------

--
-- Structure de la table `filier`
--

CREATE TABLE `filier` (
  `id` int(11) NOT NULL,
  `titel` varchar(255) NOT NULL,
  `programme_id` int(11) NOT NULL,
  `shortName` char(10) DEFAULT NULL,
  `fillierLogo` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `filier`
--

INSERT INTO `filier` (`id`, `titel`, `programme_id`, `shortName`, `fillierLogo`) VALUES
(8, 'Ingoniere Logiciele', 0, 'IL', 'DATA'),
(14, 'DATA', 0, 'DATA', 'DATA');

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

CREATE TABLE `professeur` (
  `id` int(11) NOT NULL,
  `rip` int(20) NOT NULL,
  `doctorant_type` varchar(250) NOT NULL,
  `doctorant_mention` varchar(250) NOT NULL,
  `etablissement` varchar(250) NOT NULL,
  `cni_user` varchar(30) NOT NULL,
  `imagecv` text NOT NULL,
  `Matiere_enseigne` varchar(255) NOT NULL,
  `type_contrat` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id`, `rip`, `doctorant_type`, `doctorant_mention`, `etablissement`, `cni_user`, `imagecv`, `Matiere_enseigne`, `type_contrat`) VALUES
(13, 1111, 'bb', 'bb', 'bb', 'bb', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'JAVA', 'CDI');

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

CREATE TABLE `salle` (
  `id` int(11) NOT NULL,
  `titel` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `salle`
--

INSERT INTO `salle` (`id`, `titel`) VALUES
(1, 'Salle 1'),
(2, 'Salle 2'),
(3, 'Salle 3'),
(4, 'Salle 4');

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `cni` varchar(30) NOT NULL,
  `nom` varchar(250) NOT NULL,
  `prenom` varchar(250) NOT NULL,
  `image` text NOT NULL,
  `role` varchar(250) NOT NULL,
  `tele` varchar(10) NOT NULL,
  `email` varchar(250) NOT NULL,
  `dateNaissance` date NOT NULL,
  `password` varchar(250) NOT NULL,
  `nationalite` varchar(200) NOT NULL,
  `sexe` varchar(200) NOT NULL,
  `image_cni` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`cni`, `nom`, `prenom`, `image`, `role`, `tele`, `email`, `dateNaissance`, `password`, `nationalite`, `sexe`, `image_cni`) VALUES
('bb', 'SAMIR', 'abakarim', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Professeur', 'bb', 'hh', '2024-12-05', 'bb', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('D134', 'Mohamed', 'Mohamed', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'Mohamed', 'Mohamed', '2024-12-01', 'D134', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('D13433', 'SAMIR', 'SAMIR', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'Mohamed', 'Mohamed', '2024-12-01', 'D13433', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('D13433s', 'salma', 'salma', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'Mohamed', 'Mohamed', '2024-12-01', 'D13433s', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('D13433sd', 'farouka', 'dd', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'Mohamed', 'Mohamed', '2024-12-01', 'D13433sd', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('D13433sdx', 'Hanan', 'Hanan', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'Mohamed', 'Mohamed', '2024-12-01', 'D13433sdx', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('ddd', 'Mohamed', 'Boukouch', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'dd', 'gmail.com', '2024-12-01', 'ddd', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('ddSd', 'SAMIR', 'BB', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'dd', 'gmail.com', '2024-12-01', 'ddSd', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('ddSdS', 'ALI', 'BBSS', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'dd', 'gmail.com', '2024-12-01', 'ddSdS', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('ddSdSS', 'KHAOULA', 'Boukouch', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'dd', 'gmail.com', '2024-12-01', 'ddSdSS', 'Moroccan', 'Female', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('JH800', 'Mohamed', 'Mohamed', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Professeur', 'Mohamed', 'Mohamed', '2024-11-01', 'JH800', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG'),
('Mohamed', 'Samir', 'Mohamed', 'C:\\Users\\shop souf\\OneDrive\\Pictures\\profile 1.jpg', 'Etudiant', 'Mohamed', 'Mohamed', '2024-11-01', 'Mohamed', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG'),
('Mohameddd', 'Mohamed', 'Mohamed', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG', 'Etudiant', 'Mohamed', 'Mohamed', '2024-12-01', 'Mohameddd', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\AAAA.JPG'),
('MohamedHHHHHHH', 'Mohamed', 'Boukouch', 'C:\\Users\\shop souf\\OneDrive\\Desktop\\Capture.JPG', 'Professeur', 'Mohamed', 'Mohamed', '2024-11-01', 'MohamedHHHHHHH', 'Moroccan', 'Male', 'C:\\Users\\shop souf\\OneDrive\\Pictures\\profile 1.jpg');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `absence`
--
ALTER TABLE `absence`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `un_absence` (`date`,`element_nom`,`id_filier`),
  ADD KEY `fk_element_absence` (`element_nom`);

--
-- Index pour la table `annonce`
--
ALTER TABLE `annonce`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_cours_filier` (`filier_titel`),
  ADD KEY `dk_cours_element` (`element_id`);

--
-- Index pour la table `element`
--
ALTER TABLE `element`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `un_nom` (`nom`),
  ADD UNIQUE KEY `un_element` (`nom`),
  ADD KEY `fk_element_filier` (`filier_titel`);

--
-- Index pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_emploi_user` (`cni_user`(768)),
  ADD KEY `fk_id_filier` (`filier_titel`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`cne`),
  ADD KEY `fk_user_etudiante` (`cni_user`),
  ADD KEY `un_filier_etudiant` (`titel_filier`);

--
-- Index pour la table `filier`
--
ALTER TABLE `filier`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `un_titel` (`titel`),
  ADD UNIQUE KEY `un_shortName` (`shortName`);

--
-- Index pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_prof_user` (`cni_user`),
  ADD KEY `fk_prof_element` (`Matiere_enseigne`);

--
-- Index pour la table `salle`
--
ALTER TABLE `salle`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`cni`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `absence`
--
ALTER TABLE `absence`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT pour la table `annonce`
--
ALTER TABLE `annonce`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT pour la table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `element`
--
ALTER TABLE `element`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `emploi`
--
ALTER TABLE `emploi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT pour la table `filier`
--
ALTER TABLE `filier`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT pour la table `professeur`
--
ALTER TABLE `professeur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT pour la table `salle`
--
ALTER TABLE `salle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `absence`
--
ALTER TABLE `absence`
  ADD CONSTRAINT `fk_element_absence` FOREIGN KEY (`element_nom`) REFERENCES `element` (`nom`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `un_filier_absence` FOREIGN KEY (`id_filier`) REFERENCES `filier` (`shortName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `dk_cours_element` FOREIGN KEY (`element_id`) REFERENCES `element` (`nom`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cours_filier` FOREIGN KEY (`filier_titel`) REFERENCES `filier` (`shortName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `emploi`
--
ALTER TABLE `emploi`
  ADD CONSTRAINT `fk_id_filier` FOREIGN KEY (`filier_titel`) REFERENCES `filier` (`titel`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `fk_user_etudiante` FOREIGN KEY (`cni_user`) REFERENCES `user` (`cni`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `un_filier_etudiant` FOREIGN KEY (`titel_filier`) REFERENCES `filier` (`shortName`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD CONSTRAINT `fk_prof_element` FOREIGN KEY (`Matiere_enseigne`) REFERENCES `element` (`nom`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_prof_user` FOREIGN KEY (`cni_user`) REFERENCES `user` (`cni`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
