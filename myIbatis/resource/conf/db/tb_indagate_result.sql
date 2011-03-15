USE [db_questionnaire]
GO
/****** 对象:  Table [dbo].[tb_indagate_result]    脚本日期: 03/15/2011 14:58:04 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tb_indagate_result](
	[indar_id] [int] IDENTITY(1,1) NOT NULL,
	[indar_no] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[inda_id] [int] NULL,
	[indar_person] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[indar_start_time] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[indar_end_time] [varchar](20) COLLATE Chinese_PRC_CI_AS NULL,
	[indar_time] [int] NULL,
	[indar_1] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[indar_2] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
	[indar_3] [varchar](100) COLLATE Chinese_PRC_CI_AS NULL,
PRIMARY KEY CLUSTERED 
(
	[indar_id] ASC
)WITH (IGNORE_DUP_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
USE [db_questionnaire]
GO
ALTER TABLE [dbo].[tb_indagate_result]  WITH CHECK ADD FOREIGN KEY([inda_id])
REFERENCES [dbo].[tb_indagate] ([inda_id])