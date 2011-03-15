USE [db_questionnaire]
GO
/****** 对象:  Table [dbo].[tb_question_type]    脚本日期: 03/15/2011 14:58:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_question_type](
	[quest_id] [int] IDENTITY(1,1) NOT NULL,
	[quest_type] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[quest_description] [varchar](500) COLLATE Chinese_PRC_CI_AS NULL,
	[quest_1] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[quest_2] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[quest_3] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
PRIMARY KEY CLUSTERED 
(
	[quest_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF