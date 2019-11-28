//
//  myhashing.c
//  MyHashing
//
//  Created by Jae Moon Lee on 19/11/2019.
//  Copyright © 2019 Jae Moon Lee. All rights reserved.
//
#include "stdlib.h"
#include "string.h"
#include "myhashing.h"


int     getHashValue(char *key, int hashSize){
    
	
    unsigned int number = 0;
    for(int i=0;i<strlen(key);i++){
		number = number + ((unsigned char)key[i] << i%4);
    }

    return number % hashSize;
}

void printHash(MyHash *this){
    printf("start of information *******************************\n");
    printf("table size = %d\n", this->tableSize);
    printf("key count = %d\n", this->count);
    
    float noneNullCount =0;
    for(int i=0;i<this->tableSize;i++){
        if(this->hashTable[i] != NULL){
			noneNullCount++;
        }
    }
	printf("loading factor = %f\n", (float)this->count / this->tableSize);

	noneNullCount = (noneNullCount == 0.0) ? 1.0 : noneNullCount;
	printf("chain average length = %f\n", this->count / noneNullCount);
	printf("end of imformation **********************************\n");
}


//ratio 적재율 deltaRatio 
MyHash  *createHash(float ratio, float deltaRatio){
    
	// int tableSize = 2; // 숙제에서는 이와같이 2를 설정합니다.
    int tableSize = 20000;
    MyHash  *this = (MyHash *)malloc(sizeof(MyHash));
    this->ratio = ratio;
	this->deltaRatio = deltaRatio;
    this->hashTable = (MyBucket**)malloc(tableSize*sizeof(MyBucket*));
    this->tableSize = tableSize;
    this->count = 0;
    
    for(int i=0;i<this->tableSize;i++){
        this->hashTable[i] = NULL;
    }
    
    return this;
}

// 이것은 숙제입니다.
void    destroyHash(MyHash *this){

}

// 이것도 숙제입니다.
void    expandHash(MyHash *this){
    
	int newTableSize = this->tableSize+(int)(this->tableSize*this->deltaRatio+1);

}

// 이것도 숙제입니다.
void    reduceHash(MyHash *this) {

	int newTableSize = this->tableSize - (int)(this->tableSize*this->deltaRatio + 1);
	if (newTableSize < 2)	newTableSize = 2;
}

MyBucket *findBucket(char *key, MyBucket *start){
	// start는 단순히 연결리스트이다.
	while (start != NULL) {
		if (strcmp(key, start->key) == 0) {
			return start;
		}
		start = start->next;
	}
   
    return NULL;
}

void    putString(MyHash *this, char *key, char *value){
    
    int hashValue = getHashValue(key, this->tableSize);
    MyBucket    *target = findBucket(key, this->hashTable[hashValue]);
    
    if(target != NULL){
		// 만약 이미 키간 존재한다면
		char *p = malloc(strlen(value) + 1);
		strcpy(p, value);
		free(target->value);
		target->value = p;
        return;
    }
    
	//숙제할땐 주석풀기
	/*
    if((float)this->count/(float)this->tableSize > this->ratio){
        expandHash(this);
    }
	*/
    
	// 키가 존재하지 않는다면
	target = malloc(sizeof(MyBucket));
	char *p = malloc(strlen(value) + 1);
	strcpy(p, value);
	target->value = p;
	strcpy(target->key, key);
	

	//checkPoint 위 주석풀면 에러남 해결
	target->next = this->hashTable[hashValue];
	this->hashTable[hashValue] = target;
    
	this->count++;
}

char    *getString(MyHash *this, char *key){
    
    int hashValue = getHashValue(key, this->tableSize);
    MyBucket    *target = findBucket(key, this->hashTable[hashValue]);
    if(target != NULL){
        return (char *)target->value;
    }
    return NULL;
}


void    deleteKey(MyHash *this, char *key) {

	int hashValue = getHashValue(key, this->tableSize);
	MyBucket **prev = &this->hashTable[hashValue];
	MyBucket *target = *prev;

	// 여기서 찾아서 지우시오

	if ((float)this->count / (float)this->tableSize < this->ratio) {
		reduceHash(this);
	}
}