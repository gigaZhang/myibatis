USE [ddclub]
GO
/****** 对象:  Table [dbo].[MST_HTML_LOG]    脚本日期: 03/15/2011 14:44:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MST_HTML_LOG](
	[logid] [int] IDENTITY(1,1) NOT NULL,
	[r_mhcname] [int] NULL,
	[place] [int] NULL,
	[r_mhetitle] [varchar](3000) COLLATE Chinese_PRC_CI_AS NULL,
	[r_mhedesc] [varchar](2000) COLLATE Chinese_PRC_CI_AS NULL,
	[r_mheurl] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[r_mhefile] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[r_mhekey] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[r_mhekeyurl] [varchar](200) COLLATE Chinese_PRC_CI_AS NULL,
	[mapno] [int] NULL,
	[editorname] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
	[editordate] [varchar](50) COLLATE Chinese_PRC_CI_AS NULL,
 CONSTRAINT [PK_MST_HTML_LOG] PRIMARY KEY CLUSTERED 
(
	[logid] ASC
) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF