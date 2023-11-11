package edu.javacourse.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Starter
{
    private static Logger LOGGER;

    public static void main(String[] args) {
        System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
        LOGGER = LoggerFactory.getLogger(Starter.class);

        Starter starter = new Starter();
        List<ListItem> result = starter.updateList(starter.getNewList());
    }

    public List<ListItem> updateList(List<ListItem> newItems) {
        List<ListItem> list = getCurrentList();
        Map<Long, ListItem> map = list.stream().collect(Collectors.toMap(ListItem::getItemId, Function.identity()));
        for (ListItem item : newItems) {
            if (map.containsKey(item.getItemId())) {
                map.get(item.getItemId()).setItemValue(item.getItemValue());
            } else {
                list.add(item);
                map.put(item.getItemId(), item);
            }
        }
        return list;
    }

    private List<ListItem> getCurrentList() {
        List<ListItem> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            result.add(new ListItem((long) (i + 1), 1.0));
        }
        return result;
    }

    private List<ListItem> getNewList() {
        List<ListItem> result = new ArrayList<>();
        for (int i = 3; i < 8; i++) {
            result.add(new ListItem((long) (i + 1), 10.0));
        }
        return result;
    }
}
