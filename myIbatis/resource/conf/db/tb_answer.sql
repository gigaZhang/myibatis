USE [db_questionnaire]
GO
/****** 对象:  Table [dbo].[tb_answer]    脚本日期: 03/15/2011 14:57:16 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_answer](
	[ans_id] [int] IDENTITY(1,1) NOT NULL,
	[ques_id] [int] NULL,
	[ans_value] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[ans_content] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[ans_description] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[ans_1] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[ans_2] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[ans_3] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
PRIMARY KEY CLUSTERED 
(
	[ans_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [db_questionnaire]
GO
ALTER TABLE [dbo].[tb_answer]  WITH CHECK ADD FOREIGN KEY([ques_id])
REFERENCES [dbo].[tb_question] ([ques_id])