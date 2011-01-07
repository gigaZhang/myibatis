
create database db_questionnaire
go
use db_questionnaire
go
--问题类型表
create table tb_question_type
(
	quest_id int not null primary key identity(1,1),
	quest_type varchar(20)  null,
	quest_description varchar(500) null,
	quest_1 varchar(100) null,
	quest_2 varchar(100) null,
	quest_3 varchar(100) null
)

go
insert into tb_question_type(quest_type) values('下拉列表')
insert into tb_question_type(quest_type) values('文本框')
insert into tb_question_type(quest_type) values('单选')
insert into tb_question_type(quest_type) values('多选')
go

--问卷表
create table tb_indagate
(
	inda_id int not null primary key identity(1,1),
	inda_no varchar(20)  null,--问卷编号
	inda_title varchar(100)  null,--问卷标题
	inda_theme varchar(100)  null,--问卷主题
	inda_person varchar(20) null, --调查的发起人
	inda_start_time varchar(20) null,--调查的开始时间
	inda_end_time varchar(20) null, --调查的结束时间
	channelId varchar(20) null,--频道id
	inda_1 varchar(100),
	inda_2 varchar(100),
	inda_3 varchar(100)	
)

--问题表
create table tb_question
(
	ques_id int not null primary key identity(1,1),
	inda_id int  null foreign key references tb_indagate(inda_id),--问卷id
	quest_id int  null  foreign key references tb_question_type(quest_id),--问题类型id，决定该问题的答案
	ques_no varchar(20)  null,--问题编号
	ques_content varchar(1000)  null,--问题内容
	ques_description varchar(1000) null,
	ques_1 varchar(100) null,
	ques_2 varchar(100) null,
	ques_3 varchar(100) null
)
go

--问题选项表
create table tb_answer
(
	ans_id int not null primary key identity(1,1),
	ques_id int null foreign key references tb_question(ques_id),--问题id
	ans_value varchar(100) null,
	ans_content varchar(100) null,
	ans_description varchar(1000) null,
	ans_1 varchar(100),
	ans_2 varchar(100),
	ans_3 varchar(100)	
)



--问卷结果表
create table tb_indagate_result
(
	indar_id int not null primary key identity(1,1),
	indar_no varchar(20)  null,--问卷结果编号
	inda_id int  null foreign key references tb_indagate(inda_id),--问卷id
	indar_person varchar(20) null,--答卷人
	indar_start_time varchar(20) null,--答卷日期时间
	indar_end_time varchar(20) null,--答卷结束时间
	indar_time int null,--答卷用时 单位--秒
	indar_1 varchar(100),
	indar_2 varchar(100),
	indar_3 varchar(100)	
)
create table tb_indagate_result_r
(
	indarr_id int not null primary key identity(1,1),
	indar_id int  null foreign key references tb_indagate_result(indar_id),--问卷结果ID
	ques_id int  null foreign key references tb_question(ques_id),--问题id
	ans_id int foreign key references tb_answer(ans_id)--答案id
)
go
select * from tb_indagate_result
select * from tb_answer
select * from tb_question
select * from tb_indagate
select * from tb_indagate_result_r
select * from tb_question_type

