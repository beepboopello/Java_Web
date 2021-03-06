USE [BTL]
GO
/****** Object:  Table [dbo].[customer]    Script Date: 5/7/2022 3:31:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[customer](
	[customer_id] [int] NOT NULL,
	[first_name] [nvarchar](100) NOT NULL,
	[last_name] [nvarchar](100) NOT NULL,
	[address] [nvarchar](1000) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[phone] [varchar](50) NOT NULL,
	[username] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[customer_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_item]    Script Date: 5/7/2022 3:31:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_item](
	[item_id] [int] NOT NULL,
	[order_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
	[quantity] [int] NOT NULL,
	[discount] [decimal](18, 0) NOT NULL,
	[price] [decimal](18, 0) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[item_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 5/7/2022 3:31:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[order_id] [int] NOT NULL,
	[customer_id] [int] NOT NULL,
	[store_id] [int] NOT NULL,
	[seller_id] [int] NOT NULL,
	[order_date] [datetime] NOT NULL,
	[status] [varchar](1) NOT NULL,
 CONSTRAINT [PK_orders] PRIMARY KEY CLUSTERED 
(
	[order_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[product]    Script Date: 5/7/2022 3:31:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[product](
	[product_id] [int] NOT NULL,
	[product_name] [nvarchar](250) NOT NULL,
	[category] [nvarchar](250) NOT NULL,
	[brand] [nvarchar](250) NOT NULL,
	[color] [nvarchar](50) NOT NULL,
	[size] [nvarchar](50) NOT NULL,
	[price] [decimal](18, 0) NOT NULL,
	[product_description] [nvarchar](500) NOT NULL,
	[product_image] [nvarchar](500) NOT NULL,
 CONSTRAINT [PK_product] PRIMARY KEY CLUSTERED 
(
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[seller]    Script Date: 5/7/2022 3:31:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[seller](
	[seller_id] [int] NOT NULL,
	[first_name] [nvarchar](100) NOT NULL,
	[last_name] [nvarchar](100) NOT NULL,
	[address] [nvarchar](1000) NOT NULL,
	[email] [varchar](100) NOT NULL,
	[phone] [varchar](50) NOT NULL,
	[username] [varchar](100) NOT NULL,
	[password] [varchar](100) NOT NULL,
	[store_id] [int] NOT NULL,
 CONSTRAINT [PK_seller] PRIMARY KEY CLUSTERED 
(
	[seller_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[store]    Script Date: 5/7/2022 3:31:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[store](
	[store_id] [int] NOT NULL,
	[name] [nvarchar](100) NULL,
	[address] [nvarchar](100) NULL,
 CONSTRAINT [PK_store] PRIMARY KEY CLUSTERED 
(
	[store_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[store_available]    Script Date: 5/7/2022 3:31:28 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[store_available](
	[store_id] [int] NOT NULL,
	[product_id] [int] NOT NULL,
	[quantity] [nchar](10) NULL,
 CONSTRAINT [PK_store_available] PRIMARY KEY CLUSTERED 
(
	[store_id] ASC,
	[product_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[order_item]  WITH CHECK ADD  CONSTRAINT [FK_order_item_orders] FOREIGN KEY([order_id])
REFERENCES [dbo].[orders] ([order_id])
GO
ALTER TABLE [dbo].[order_item] CHECK CONSTRAINT [FK_order_item_orders]
GO
ALTER TABLE [dbo].[order_item]  WITH CHECK ADD  CONSTRAINT [FK_order_item_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[order_item] CHECK CONSTRAINT [FK_order_item_product]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_customer] FOREIGN KEY([customer_id])
REFERENCES [dbo].[customer] ([customer_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_customer]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_seller] FOREIGN KEY([seller_id])
REFERENCES [dbo].[seller] ([seller_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_seller]
GO
ALTER TABLE [dbo].[orders]  WITH CHECK ADD  CONSTRAINT [FK_orders_store] FOREIGN KEY([store_id])
REFERENCES [dbo].[store] ([store_id])
GO
ALTER TABLE [dbo].[orders] CHECK CONSTRAINT [FK_orders_store]
GO
ALTER TABLE [dbo].[seller]  WITH CHECK ADD  CONSTRAINT [FK_seller_store] FOREIGN KEY([store_id])
REFERENCES [dbo].[store] ([store_id])
GO
ALTER TABLE [dbo].[seller] CHECK CONSTRAINT [FK_seller_store]
GO
ALTER TABLE [dbo].[store_available]  WITH CHECK ADD  CONSTRAINT [FK_store_available_product] FOREIGN KEY([product_id])
REFERENCES [dbo].[product] ([product_id])
GO
ALTER TABLE [dbo].[store_available] CHECK CONSTRAINT [FK_store_available_product]
GO
ALTER TABLE [dbo].[store_available]  WITH CHECK ADD  CONSTRAINT [FK_store_available_store] FOREIGN KEY([store_id])
REFERENCES [dbo].[store] ([store_id])
GO
ALTER TABLE [dbo].[store_available] CHECK CONSTRAINT [FK_store_available_store]
GO
