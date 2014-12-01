package answer.king.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import answer.king.model.Item;
import answer.king.model.Reciept;
import answer.king.service.ItemService;
import java.math.BigDecimal;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.GET)
	public List<Item> getAll() {
		return itemService.getAll();
	}

	@RequestMapping(method = RequestMethod.POST)
	public Item create(@RequestBody Item item) {
		return itemService.save(item);
	}
        
        @RequestMapping(value = "/{id}/changePrice", method = RequestMethod.PUT)
	public Item changePrice(@PathVariable("id") Long id, @RequestBody BigDecimal price) {
		return itemService.changePrice(id, price);
	}
}
