USE [ddclub]
GO
/****** 对象:  Table [dbo].[MST_HTML_ELEMENT]    脚本日期: 03/15/2011 14:32:18 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MST_HTML_ELEMENT](
	[mhe_id] [int] NOT NULL,
	[mhc_id] [int] NOT NULL,
	[mhe_name] [varchar](80) COLLATE Chinese_PRC_CI_AS NOT NULL,
	[mhe_desc] [varchar](2000) COLLATE Chinese_PRC_CI_AS NULL,
	[mhe_url] [varchar](3000) COLLATE Chinese_PRC_CI_AS NULL,
	[mhe_mapno] [int] NULL,
	[mhe_hot] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[mhe_key] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
	[mhe_keyurl] [varchar](500) COLLATE Chinese_PRC_CI_AS NULL,
	[mhe_tips] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[mhe_order] [int] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF