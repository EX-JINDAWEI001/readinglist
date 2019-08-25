package com.example.readinglist.web;

import com.example.readinglist.config.AmazonProperties;
import com.example.readinglist.dao.ReadingListRepository;
import com.example.readinglist.dto.Book;
import com.example.readinglist.dto.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ReadingListController {

    private AmazonProperties amazonProperties;

    private ReadingListRepository readingListRepository;

    private static Logger logger = LoggerFactory.getLogger(ReadingListController.class);

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

    /**
     * 查询列表
     *
     * @param reader
     * @param model
     * @return
     */
    @RequestMapping(value = "/readerBooks.do", method = RequestMethod.GET)
    public String readerBooks(Reader reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        logger.info("电极法VBv好：{}, associateId:{}", readingList, amazonProperties.getAssociateId());
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId());
        }
        return "readingList";
    }

    /**
     * 新增列表
     *
     * @param reader
     * @param book
     * @return
     */
    @RequestMapping(value = "/addToReadingList.do", method = RequestMethod.GET)
    public String addToReadingList(Reader reader, Book book) {
        book.setReader(reader);
        logger.info("金大为哈哈哈哈或或或或或或或或或或或或:{}", book);
        readingListRepository.save(book);
        return "redirect:/readerBooks.do";
    }

	/*void CreateList(LinkList *L,int n){
		//创建一个有n个结点的链表
		LinkList p;                                 //新结点
		int i;                                      //循环变量
		L = (LinkList)malloc(sizeof(LNode));
		L->next = NULL;                             //构建一个带头结点的空链表
		for(i=0;i<n;i++){
			p = (listLink1)malloc(sizeof(LNode));   //申请结点的内存
			scanf(&(p->data));                      //赋值
			p->next = L->next;
			L->next = p;                            //插入的表头
		}
	}



	#define NULL 0
	#define LENGTH sizeof(struct LinkList)
	#include "stdlib.h"

	struct LinkList{
		int data;
		struct LinkList *next;
	};

	void createEmptyLinkList(){
		struct LinkList *head;						//定义头结点
		head = (struct LinkList *)malloc(LENGTH);
		head->next = NULL;							//构建一个带头结点的空链表
		return head;
	}

	main(){
		//生成一个带头结点的空链表L2
		struct LinkList *L2 = createEmptyLinkList();
		//遍历现有链表L1，当data为偶数时，从L1删除该节点，并将该结点加入L2
		struct LinkList *pre, *suf,*f,*p,*q;
		pre = L1->next;   //头结点
		suf = pre->next;  //首结点
		q = L2->next;	  //头结点
		if(suf<>NULL){//非空表
			do{
				if (suf->data % 2 == 0){
					//从L1删除该节点
					f=suf;
					pre->next = suf->next;
					suf = suf->next;
					free(f);

					//将该结点加入L2
					p = (struct LinkList *)malloc(LENGTH);
					p->data = suf->data;
					p->next=NULL;
					q->next=p;
					q=p;
				}

				pre = suf;			//指针移向下一个结点
				suf = suf->next;	//指针移向下一个结点

			}while (pre->next<>NULL)
		}

	}*/

}
