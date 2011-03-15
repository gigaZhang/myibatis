USE [db_questionnaire]
GO
/****** 对象:  Table [dbo].[tb_indagate]    脚本日期: 03/15/2011 14:57:40 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_indagate](
	[inda_id] [int] IDENTITY(1,1) NOT NULL,
	[inda_no] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_title] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_theme] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_person] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_start_time] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_end_time] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[channelId] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_1] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_2] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_3] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
PRIMARY KEY CLUSTERED 
(
	[inda_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF