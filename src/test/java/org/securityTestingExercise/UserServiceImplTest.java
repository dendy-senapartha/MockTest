package org.securityTestingExercise;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

/**
 * Project: Quiz8
 * Package: securityTestingExercise
 * Description : lakukan verifikasi jika object user berhasil mendapatkan pasword barunya,
 * dan method updateUser() pada userDAO dipanggil dengan benar.
 * hint : gunakan method static any() untuk melakukan stub test
 */
public class UserServiceImplTest {
    SecurityService seSer = mock(SecurityService.class);
    User user = mock(User.class);
    UserDAO userDao = mock(UserDAO.class);
    final String MSG = "Terverifikasi...";


    @Test
    public void verifyCheckUpdatePassword()  throws Exception{
        UserServiceImpl sut = new UserServiceImpl(userDao, seSer);
        when(user.getPassword()).thenReturn(MSG);
        sut.assignPassword(user);
        verify(user).setPassword(any());
        verify(userDao).updateUser(user);
    }
}
