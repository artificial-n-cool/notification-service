build:
	docker-compose build
	docker-compose up
clean:
	docker stop notifications-app
	docker stop mongo-db-notifications
	docker rm notifications-app
	docker rm mongo-db-notifications
	docker rmi notificationsapp_notifications-app
