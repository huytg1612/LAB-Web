USE [master]
GO
/****** Object:  Database [P0013]    Script Date: 9/24/2019 9:15:21 PM ******/
CREATE DATABASE [P0013]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'P0013', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\P0013.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'P0013_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\P0013_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [P0013] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [P0013].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [P0013] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [P0013] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [P0013] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [P0013] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [P0013] SET ARITHABORT OFF 
GO
ALTER DATABASE [P0013] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [P0013] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [P0013] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [P0013] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [P0013] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [P0013] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [P0013] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [P0013] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [P0013] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [P0013] SET  DISABLE_BROKER 
GO
ALTER DATABASE [P0013] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [P0013] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [P0013] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [P0013] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [P0013] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [P0013] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [P0013] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [P0013] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [P0013] SET  MULTI_USER 
GO
ALTER DATABASE [P0013] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [P0013] SET DB_CHAINING OFF 
GO
ALTER DATABASE [P0013] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [P0013] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [P0013] SET DELAYED_DURABILITY = DISABLED 
GO
USE [P0013]
GO
/****** Object:  Table [dbo].[Info]    Script Date: 9/24/2019 9:15:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Info](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Address] [nvarchar](100) NULL,
	[Tel] [varchar](12) NULL,
	[Email] [varchar](100) NULL,
	[Picture] [varchar](50) NULL,
 CONSTRAINT [PK_Info] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Menus]    Script Date: 9/24/2019 9:15:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Menus](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NULL,
	[Description] [nvarchar](max) NULL,
	[Price] [float] NULL,
 CONSTRAINT [PK_Menus] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductMenus]    Script Date: 9/24/2019 9:15:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductMenus](
	[MenuId] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
 CONSTRAINT [PK_ProductMenus] PRIMARY KEY CLUSTERED 
(
	[MenuId] ASC,
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Products]    Script Date: 9/24/2019 9:15:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NULL,
	[Picture] [nvarchar](200) NULL,
	[Description] [nvarchar](max) NULL,
	[Price] [float] NULL,
 CONSTRAINT [PK_Products] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Schedules]    Script Date: 9/24/2019 9:15:21 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Schedules](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Weekday] [varchar](50) NULL,
	[OpenAt] [varchar](50) NULL,
	[CloseAt] [varchar](50) NULL,
	[InfoId] [int] NULL,
 CONSTRAINT [PK_Schedules] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Info] ON 

INSERT [dbo].[Info] ([Id], [Address], [Tel], [Email], [Picture]) VALUES (1, N'242- 244 Phan Xich Long,phuong 1,Quan Phu Nhuan,Q.3', N'123456789', N'tokyodeli@gmailcomm', N'google-image.jpg')
SET IDENTITY_INSERT [dbo].[Info] OFF
SET IDENTITY_INSERT [dbo].[Menus] ON 

INSERT [dbo].[Menus] ([Id], [Name], [Description], [Price]) VALUES (1, N'Menu Sushi', N'Sieu ngon sieu bo sieu re', 15)
INSERT [dbo].[Menus] ([Id], [Name], [Description], [Price]) VALUES (2, N'Menu BBQ', N'Super ngon ', 30)
SET IDENTITY_INSERT [dbo].[Menus] OFF
INSERT [dbo].[ProductMenus] ([MenuId], [ProductId]) VALUES (1, 1)
INSERT [dbo].[ProductMenus] ([MenuId], [ProductId]) VALUES (1, 2)
INSERT [dbo].[ProductMenus] ([MenuId], [ProductId]) VALUES (2, 1)
INSERT [dbo].[ProductMenus] ([MenuId], [ProductId]) VALUES (2, 2)
SET IDENTITY_INSERT [dbo].[Products] ON 

INSERT [dbo].[Products] ([Id], [Name], [Picture], [Description], [Price]) VALUES (1, N'Bunny Sushi', N'product1.jpg', N'Sushi sieu ngon', 15)
INSERT [dbo].[Products] ([Id], [Name], [Picture], [Description], [Price]) VALUES (2, N'Kika Shushi', N'product2.jpg', N'Ngon hon bunny sushi', 30)
SET IDENTITY_INSERT [dbo].[Products] OFF
SET IDENTITY_INSERT [dbo].[Schedules] ON 

INSERT [dbo].[Schedules] ([Id], [Weekday], [OpenAt], [CloseAt], [InfoId]) VALUES (1, N'Monday', N'11', N'23', 1)
INSERT [dbo].[Schedules] ([Id], [Weekday], [OpenAt], [CloseAt], [InfoId]) VALUES (2, N'Tuesday', N'11', N'23', 1)
INSERT [dbo].[Schedules] ([Id], [Weekday], [OpenAt], [CloseAt], [InfoId]) VALUES (3, N'Wednesday', N'11', N'23', 1)
INSERT [dbo].[Schedules] ([Id], [Weekday], [OpenAt], [CloseAt], [InfoId]) VALUES (4, N'Thursday', N'11', N'23', 1)
INSERT [dbo].[Schedules] ([Id], [Weekday], [OpenAt], [CloseAt], [InfoId]) VALUES (5, N'Friday', N'9', N'23', 1)
INSERT [dbo].[Schedules] ([Id], [Weekday], [OpenAt], [CloseAt], [InfoId]) VALUES (6, N'Saturday', N'9', N'23', 1)
INSERT [dbo].[Schedules] ([Id], [Weekday], [OpenAt], [CloseAt], [InfoId]) VALUES (7, N'Sunday', N'9', N'23', 1)
SET IDENTITY_INSERT [dbo].[Schedules] OFF
ALTER TABLE [dbo].[ProductMenus]  WITH CHECK ADD  CONSTRAINT [FK_ProductMenus_Menus] FOREIGN KEY([MenuId])
REFERENCES [dbo].[Menus] ([Id])
GO
ALTER TABLE [dbo].[ProductMenus] CHECK CONSTRAINT [FK_ProductMenus_Menus]
GO
ALTER TABLE [dbo].[ProductMenus]  WITH CHECK ADD  CONSTRAINT [FK_ProductMenus_Products] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Products] ([Id])
GO
ALTER TABLE [dbo].[ProductMenus] CHECK CONSTRAINT [FK_ProductMenus_Products]
GO
ALTER TABLE [dbo].[Schedules]  WITH CHECK ADD  CONSTRAINT [FK_Schedules_Info] FOREIGN KEY([InfoId])
REFERENCES [dbo].[Info] ([Id])
GO
ALTER TABLE [dbo].[Schedules] CHECK CONSTRAINT [FK_Schedules_Info]
GO
USE [master]
GO
ALTER DATABASE [P0013] SET  READ_WRITE 
GO
