USE [db_questionnaire]
GO
/****** 对象:  Table [dbo].[tb_question]    脚本日期: 03/15/2011 14:58:35 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_question](
	[ques_id] [int] IDENTITY(1,1) NOT NULL,
	[inda_id] [int] NULL,
	[quest_id] [int] NULL,
	[ques_no] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[ques_content] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[ques_description] [varchar](1000) COLLATE Chinese_PRC_CI_AS NULL,
	[ques_1] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[ques_2] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[ques_3] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
PRIMARY KEY CLUSTERED 
(
	[ques_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [db_questionnaire]
GO
ALTER TABLE [dbo].[tb_question]  WITH CHECK ADD FOREIGN KEY([inda_id])
REFERENCES [dbo].[tb_indagate] ([inda_id])
GO
ALTER TABLE [dbo].[tb_question]  WITH CHECK ADD FOREIGN KEY([quest_id])
REFERENCES [dbo].[tb_question_type] ([quest_id])