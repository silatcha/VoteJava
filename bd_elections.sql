-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  jeu. 29 avr. 2021 à 11:02
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `bd_elections`
--

-- --------------------------------------------------------

--
-- Structure de la table `administrateur`
--

DROP TABLE IF EXISTS `administrateur`;
CREATE TABLE IF NOT EXISTS `administrateur` (
  `mdp` varchar(50) NOT NULL,
  PRIMARY KEY (`mdp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `administrateur`
--

INSERT INTO `administrateur` (`mdp`) VALUES
('1245608op'),
('momo');

-- --------------------------------------------------------

--
-- Structure de la table `candidat`
--

DROP TABLE IF EXISTS `candidat`;
CREATE TABLE IF NOT EXISTS `candidat` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `partis` varchar(50) NOT NULL,
  `sexe` varchar(50) NOT NULL,
  `ville` varchar(50) NOT NULL,
  `nationalite` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `candidat`
--

INSERT INTO `candidat` (`nom`, `prenom`, `partis`, `sexe`, `ville`, `nationalite`) VALUES
(' BIYA', 'Paul', 'RDPC', 'Masculin', 'Yaounde', 'Camerounais'),
('KAMTO', 'Maurice', 'SDF', 'Masculin', 'Douala', 'Camerounaise'),
('JOSHUA', 'Osih', 'SDF', 'Masculin', 'Douala', 'Camerounais'),
('AKERE', 'Muna', 'FPD', 'Masculin', 'Yaounde', 'Camerounais'),
('GARGA', 'Haman Adji', 'ADD', 'Masculin', 'Douala', 'Camerounais'),
('ADAMOU', 'Ndam Njoya', 'UDC', 'Masculin', 'Yaounde', 'Camerounais'),
('CABRAL', 'Libii', 'UNIVERS', 'Masculin', 'Yaounde', 'Camerounais'),
('MATOMBA', 'Serge Espoir', 'PURS', 'Masculin', 'Yaounde', 'Camerounais'),
('NDIFOR', 'Afanwi Franklin', 'MCNC', 'Masculin', 'Douala', 'Camerounais');

-- --------------------------------------------------------

--
-- Structure de la table `electeurs`
--

DROP TABLE IF EXISTS `electeurs`;
CREATE TABLE IF NOT EXISTS `electeurs` (
  `email` varchar(50) NOT NULL,
  `num_electeur` int(100) NOT NULL,
  `mdp` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `partis` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `logs`
--

DROP TABLE IF EXISTS `logs`;
CREATE TABLE IF NOT EXISTS `logs` (
  `email` varchar(50) NOT NULL,
  `nom_candidat` varchar(50) NOT NULL,
  `partis` varchar(50) NOT NULL,
  `nom` varchar(50) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `partis`
--

DROP TABLE IF EXISTS `partis`;
CREATE TABLE IF NOT EXISTS `partis` (
  `nom` varchar(50) NOT NULL,
  `nom_candidat` varchar(50) NOT NULL,
  `id` int(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `scrutin`
--

DROP TABLE IF EXISTS `scrutin`;
CREATE TABLE IF NOT EXISTS `scrutin` (
  `type` varchar(50) NOT NULL,
  `nbr_candidats` int(50) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `id` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `scrutin`
--

INSERT INTO `scrutin` (`type`, `nbr_candidats`, `date_debut`, `date_fin`, `id`) VALUES
('Presidentielle', 5, '2021-04-15', '2021-05-12', 'Scrutin1'),
('Presidentielle', 9, '2021-04-02', '2021-04-24', 'Scrutin2'),
('Presidentielle', 9, '2021-04-16', '2021-04-30', 'Scrutin4'),
('Legislative', 9, '2021-04-08', '2021-04-30', 'Scrutin8');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `adresse` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL,
  `tel` int(50) NOT NULL,
  `nom_uti` varchar(30) NOT NULL,
  `datenaiss` date NOT NULL,
  `profession` varchar(30) NOT NULL,
  PRIMARY KEY (`mdp`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`nom`, `prenom`, `adresse`, `email`, `mdp`, `tel`, `nom_uti`, `datenaiss`, `profession`) VALUES
('Mbaho', 'Bissane', 'Douala', 'bisannembaho12@gmail.com', '123rf4ty', 655470896, 'Bissane14', '1999-09-29', 'Etudiante'),
('v', 'vb', 'va', 'vm', '123rfbn', 12345678, 'mn', '2021-04-15', 'Eleve'),
('Ngaffag', 'Crespo', 'Douala', 'ngaffagcrespo9@gmail.com', '1245608op', 656069801, 'Crespo1', '2000-04-13', 'Medecin'),
('Durois', 'GEORges', 'Bonamoussadi', 'durois@gmail.com', 'momo', 65668792, 'DuroisU', '2021-04-22', 'Etudiant');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `administrateur`
--
ALTER TABLE `administrateur`
  ADD CONSTRAINT `md1` FOREIGN KEY (`mdp`) REFERENCES `utilisateurs` (`mdp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
