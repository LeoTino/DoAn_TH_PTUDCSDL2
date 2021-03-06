USE [DoAn]
GO
/****** Object:  Table [dbo].[CauHoi]    Script Date: 5/23/2018 11:10:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CauHoi](
	[STTCauHoi] [int] NOT NULL,
	[NoiDungCauHoi] [nvarchar](1000) NULL,
	[CauTraLoiChinhXac] [nvarchar](1000) NULL,
PRIMARY KEY CLUSTERED 
(
	[STTCauHoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 5/23/2018 11:10:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[Username] [nvarchar](100) NOT NULL,
	[Password] [nvarchar](100) NULL,
	[LoaiTK] [nchar](10) NULL,
PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TraLoi]    Script Date: 5/23/2018 11:10:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TraLoi](
	[Username] [nvarchar](100) NOT NULL,
	[STTCauHoi] [int] NOT NULL,
	[CauTraLoi] [nvarchar](1000) NULL CONSTRAINT [DF_TraLoi_CauTraLoi]  DEFAULT (NULL),
PRIMARY KEY CLUSTERED 
(
	[Username] ASC,
	[STTCauHoi] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[UserCur]    Script Date: 5/23/2018 11:10:53 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserCur](
	[Username] [nvarchar](100) NOT NULL,
	[CurrentIndex] [int] NULL CONSTRAINT [DF_UserCur_CurrentIndex]  DEFAULT ((1)),
 CONSTRAINT [PK_UserCur_1] PRIMARY KEY CLUSTERED 
(
	[Username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (1, N'Đường gì dài nhất?', N'Đường đời')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (2, N'Trò chơi gì càng thắng càng thua?', N'Đua xe đạp')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (3, N'Con trai cái gì quý nhất?', N'Ngọc trai')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (4, N'Trong một cuộc đua, nếu bạn vượt qua người thứ nhì, bạn sẽ về vị trí thứ mấy?', N'Bạn sẽ về vị trí thứ 2')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (5, N'Trên đồng cỏ có 6 con bò, đếm đi đếm lại chỉ có 12 cái chân. Hỏi tại sao?', N'Con bò này cưỡi lên lưng con bò kia theo dây chuyền và vòng tròn nên mỗi con chỉ có 2 chân!')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (6, N'2 con vịt đi trước 2 con vịt, 2 con vịt đi sau 2 con vịt, 2 con vịt đi giữa 2 con vịt. Hỏi có mấy con vịt?', N'4 con vịt')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (7, N'Có 1 bà kia không biết bơi, xuống nước là bả chết. Một hôm bà đi tàu, bỗng nhiên tàu chìm, nhưng bà ko chết.Tại sao (ko ai cứu hết)?', N'Bà ấy đi tàu ngầm')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (8, N'Lịch nào dài nhất?', N'Lịch sử')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (9, N'Quần rộng nhất là quần gì?', N'Quần đảo')
INSERT [dbo].[CauHoi] ([STTCauHoi], [NoiDungCauHoi], [CauTraLoiChinhXac]) VALUES (10, N'Cái gì của chồng mà vợ thích cầm nhất (không nghĩ lung tung)?', N'Tiền')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [LoaiTK]) VALUES (N'admin', N'admin', N'1         ')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [LoaiTK]) VALUES (N'Nguyen Van A', N'hs', N'0         ')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [LoaiTK]) VALUES (N'Nguyen Van B', N'hs', N'0         ')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [LoaiTK]) VALUES (N'Nguyen Van C', N'hs', N'0         ')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [LoaiTK]) VALUES (N'Tran Thi D', N'gv', N'1         ')
INSERT [dbo].[TaiKhoan] ([Username], [Password], [LoaiTK]) VALUES (N'user', N'user', N'0         ')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 1, N'Đường đời')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 2, N'Đua xe đạp')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 3, N'Ngọc trai')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 4, N'Bạn về nhất')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 5, N'Vì bò bị què')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 6, N'6 con vịt')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 7, N'Bà đi tàu hỏa')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 8, N'Lịch âm dương')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 9, N'Quần thể')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van A', 10, N'Tiền')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 1, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 2, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 3, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 4, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 5, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 6, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 7, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 8, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 9, N'test đáp án')
INSERT [dbo].[TraLoi] ([Username], [STTCauHoi], [CauTraLoi]) VALUES (N'Nguyen Van B', 10, N'test đáp án')
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'ddsa', 8)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'dsa', 1)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'dsadsa', 1)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'hs', 2)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'hs1', 1)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'Nguyen Van A', 3)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'Nguyen Van B', 10)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'null', 1)
INSERT [dbo].[UserCur] ([Username], [CurrentIndex]) VALUES (N'v', 1)
