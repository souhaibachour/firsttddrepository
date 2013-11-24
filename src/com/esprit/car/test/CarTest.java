package com.esprit.car.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

import com.esprit.car.Car;
import com.esprit.smsModule.SmsService;

@RunWith(MockitoJUnitRunner.class)
public class CarTest {

	@InjectMocks
	Car car;

	@Mock
	SmsService smsService;

	@Before
	public void setUp() {
		when(smsService.getVersion()).thenReturn("version 1.1");

	}

	@Test
	public void itShouldStartWhenKeyIsTurnedRight() {

		car.turnKey("right");
		boolean state = car.isStarted();
		assertTrue(state);

	}

	@Test
	public void itShouldStopWhenKeyIsTurnedLeft() {

		car.turnKey("left");
		boolean state = car.isStarted();
		assertFalse(state);

	}

	@Test(expected = IllegalArgumentException.class)
	public void itShouldThrowIllegalArgumentExceptionWhenWrongArgumentIsGiven() {

		car.turnKey("wrong");
	}

	@Test
	public void itShouldSendAnSMSNotificationWhenWrongArgumentIsGiven() {
		try {
			car.turnKey("wrong");
		} catch (Exception e) {
			// TODO: handle exception
		}

		verify(smsService).sendMessage(matches("52575902"), anyString());

	}

}
