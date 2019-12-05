package cn.ec.dao;

import cn.ec.model.Card;

public interface CardMapper {

    Card selectCardByPid(String pid);
}
