USE [ddclub]
GO
/****** 对象:  Table [dbo].[MST_HTML_CREATOR]    脚本日期: 03/15/2011 14:31:48 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MST_HTML_CREATOR](
	[mhc_id] [int] IDENTITY(1,1) NOT NULL,
	[mhc_name] [varchar](50) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[mhc_url] [varchar](50) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[mhc_outurl] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[pic_counts] [int] NULL,
	[txt_counts] [int] NULL,
	[mhc_mapno] [int] NULL CONSTRAINT [DF_MST_HTML_CREATOR_mhc_mapno]  DEFAULT (21),
	[pub_status] [int] NULL,
	[mhc_module] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[mhc_color] [int] NULL CONSTRAINT [DF_MST_HTML_CREATOR_mhc_color]  DEFAULT (0),
	[mhc_keyword] [int] NULL CONSTRAINT [DF_MST_HTML_CREATOR_mhc_keyword]  DEFAULT (0),
	[mhc_titsize] [int] NULL CONSTRAINT [DF_MST_HTML_CREATOR_mhc_titsize]  DEFAULT (30),
	[mhc_descsize] [int] NULL CONSTRAINT [DF_MST_HTML_CREATOR_mhc_descsize]  DEFAULT (50),
	[mhc_preview] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[mhc_published] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[mhc_outpath] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL CONSTRAINT [DF_MST_HTML_CREATOR_mhc_outpath]  DEFAULT ('D:/'),
	[mhc_inpath] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL CONSTRAINT [DF_MST_HTML_CREATOR_mhc_inpath]  DEFAULT ('/proj/home/stencil/'),
	[mhc_order] [int] NULL,
	[mhc_stat] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
 CONSTRAINT [PK_MST_HTML_CREATOR] PRIMARY KEY CLUSTERED 
(
	[mhc_id] ASC
) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF