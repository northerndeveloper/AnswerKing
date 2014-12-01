package answer.king.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import answer.king.model.Item;
import answer.king.repo.ItemRepository;
import java.math.BigDecimal;

@Service
@Transactional
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAll() {
        List<Item> items = new ArrayList<>();
        for (Item item : itemRepository.findAll()) {
            items.add(item);
        }
        return items;
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item changePrice(Long id, BigDecimal price) {
        Item item = itemRepository.findOne(id);
        item.setPrice(price);
        return item;
    }

}
