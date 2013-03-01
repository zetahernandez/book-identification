define(["views/IndexView", "views/HeaderView", "views/VolumeListView", "views/CategoryListView", "views/VolumeInfoView", "views/VolumeInfoDetailView", "views/NavigationView", "views/SearchVolumeView", "views/LoadMoreView", "controllers/IndexController", "controllers/HeaderController", "controllers/VolumeListController", "controllers/CategoryListController", "controllers/VolumeInfoDetailController", "controllers/SearchVolumeController", "controllers/LoadMoreController", "models/Volume", "models/VolumeInfo", "models/Category", "models/ImageLink", "models/IndustryIdentifier", "app/router", "routes/IndexRoute", "routes/VolumeInfoDetailRoute", "routes/VolumesRoute"],

function (IndexView, HeaderView, VolumeListView, CategoryListView, VolumeInfoView, VolumeInfoDetailView, NavigationView, SearchVolumeView, LoadMoreView, IndexController, HeaderController, VolumeListController, CategoryListController, VolumeInfoDetailController, SearchVolumeController, LoadMoreController, Volume, VolumeInfo, Category, ImageLink, IndustryIdentifier, Router, IndexRoute, VolumeInfoDetailRoute, VolumesRoute) { /* Module Pattern */
	var App = Ember.Application.create();
	App.IndexView = IndexView;
	App.HeaderView = HeaderView;
	App.VolumeListView = VolumeListView;
	App.CategoryListView = CategoryListView;
	App.VolumeInfoView = VolumeInfoView;
	App.VolumeInfoDetailView = VolumeInfoDetailView;
	App.NavigationView = NavigationView;
	App.SearchVolumeView = SearchVolumeView;
	App.LoadMoreView = LoadMoreView;
	App.IndexController = IndexController;
	App.HeaderController = HeaderController;
	App.VolumeListController = VolumeListController;
	App.CategoryListController = CategoryListController;
	App.VolumeInfoDetailController = VolumeInfoDetailController;
	App.SearchVolumeController = SearchVolumeController;
	App.LoadMoreController = LoadMoreController;
	App.Router.map(Router);
	App.Volume = Volume;
	App.VolumeInfo = VolumeInfo;
	App.Category = Category;
	App.ImageLink = ImageLink;
	App.IndustryIdentifier = IndustryIdentifier;
	App.IndexRoute = IndexRoute;
	App.VolumesRoute = VolumesRoute;
	App.VolumeInfoDetailRoute = VolumeInfoDetailRoute;

	DS.RESTAdapter.configure("plurals", {
		'volume': 'volumes',
		'volume_info': 'volumesInfo',
		'category': 'categories',
		'industry_identifier': 'industryIdentifiers',
		'image_link': 'imageLinks'
	});

	DS.RESTAdapter.map('BooksApp.Volume', {
		volumeInfo: {
			embedded: 'load'
		}
	});

	DS.RESTAdapter.map('BooksApp.VolumeInfo', {
		imageLinks: {
			embedded: 'load'
		},
		industryIdentifiers: {
			embedded: 'load'
		}
	});

	DS.RESTAdapter.map('BooksApp.Category', {
		subCategories: {
			embedded: 'load'
		}
	});

	App.store = DS.Store.create({
		revision: 11,
		adapter: DS.RESTAdapter.create({
			bulkCommit: false,

			namespace: 'rest' // you should change the first
			// segment
			// according to the application's folder
			// path on the server.
		})

	});
	return App;
});