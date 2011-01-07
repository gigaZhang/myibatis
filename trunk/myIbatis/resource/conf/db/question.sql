
create database db_questionnaire
go
use db_questionnaire
go
--�������ͱ�
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
insert into tb_question_type(quest_type) values('�����б�')
insert into tb_question_type(quest_type) values('�ı���')
insert into tb_question_type(quest_type) values('��ѡ')
insert into tb_question_type(quest_type) values('��ѡ')
go

--�ʾ��
create table tb_indagate
(
	inda_id int not null primary key identity(1,1),
	inda_no varchar(20)  null,--�ʾ���
	inda_title varchar(100)  null,--�ʾ����
	inda_theme varchar(100)  null,--�ʾ�����
	inda_person varchar(20) null, --����ķ�����
	inda_start_time varchar(20) null,--����Ŀ�ʼʱ��
	inda_end_time varchar(20) null, --����Ľ���ʱ��
	channelId varchar(20) null,--Ƶ��id
	inda_1 varchar(100),
	inda_2 varchar(100),
	inda_3 varchar(100)	
)

--�����
create table tb_question
(
	ques_id int not null primary key identity(1,1),
	inda_id int  null foreign key references tb_indagate(inda_id),--�ʾ�id
	quest_id int  null  foreign key references tb_question_type(quest_id),--��������id������������Ĵ�
	ques_no varchar(20)  null,--������
	ques_content varchar(1000)  null,--��������
	ques_description varchar(1000) null,
	ques_1 varchar(100) null,
	ques_2 varchar(100) null,
	ques_3 varchar(100) null
)
go

--����ѡ���
create table tb_answer
(
	ans_id int not null primary key identity(1,1),
	ques_id int null foreign key references tb_question(ques_id),--����id
	ans_value varchar(100) null,
	ans_content varchar(100) null,
	ans_description varchar(1000) null,
	ans_1 varchar(100),
	ans_2 varchar(100),
	ans_3 varchar(100)	
)



--�ʾ�����
create table tb_indagate_result
(
	indar_id int not null primary key identity(1,1),
	indar_no varchar(20)  null,--�ʾ������
	inda_id int  null foreign key references tb_indagate(inda_id),--�ʾ�id
	indar_person varchar(20) null,--�����
	indar_start_time varchar(20) null,--�������ʱ��
	indar_end_time varchar(20) null,--������ʱ��
	indar_time int null,--�����ʱ ��λ--��
	indar_1 varchar(100),
	indar_2 varchar(100),
	indar_3 varchar(100)	
)
create table tb_indagate_result_r
(
	indarr_id int not null primary key identity(1,1),
	indar_id int  null foreign key references tb_indagate_result(indar_id),--�ʾ���ID
	ques_id int  null foreign key references tb_question(ques_id),--����id
	ans_id int foreign key references tb_answer(ans_id)--��id
)
go
select * from tb_indagate_result
select * from tb_answer
select * from tb_question
select * from tb_indagate
select * from tb_indagate_result_r
select * from tb_question_type

