define([ "require", "ember", "ember_data"], function(require, Ember) {
	var Category = DS.Model.extend({
		primaryKey: 'id',
		id : DS.attr('number'),
		categoryName : DS.attr('string'),
		parent :DS.belongsTo('BooksApp.Category'),
		subCategories: DS.hasMany('BooksApp.Category',{ embedded: true }),
		
		haveParent : function() {
			return this.get('parent') != null && this.get('parent') != undefined;
		}.property('parent'),
		
		categoryLevel : function(category) {
			var level = 0;
			
			if (category.haveParent)
				level = level + categoryLevel(category.parent) + 1;
			
			return level;
		}.property()
		
		
	});
	return Category;
});