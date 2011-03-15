USE [db_questionnaire]
GO
/****** 对象:  Table [dbo].[tb_indagate_result_r]    脚本日期: 03/15/2011 14:58:19 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tb_indagate_result_r](
	[indarr_id] [int] IDENTITY(1,1) NOT NULL,
	[indar_id] [int] NULL,
	[ques_id] [int] NULL,
	[ans_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[indarr_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
USE [db_questionnaire]
GO
ALTER TABLE [dbo].[tb_indagate_result_r]  WITH CHECK ADD FOREIGN KEY([ans_id])
REFERENCES [dbo].[tb_answer] ([ans_id])
GO
ALTER TABLE [dbo].[tb_indagate_result_r]  WITH CHECK ADD FOREIGN KEY([indar_id])
REFERENCES [dbo].[tb_indagate_result] ([indar_id])
GO
ALTER TABLE [dbo].[tb_indagate_result_r]  WITH CHECK ADD FOREIGN KEY([ques_id])
REFERENCES [dbo].[tb_question] ([ques_id])