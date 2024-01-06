package com.sa46lll.blogsearcher.config;

import com.sa46lll.blogsearcher.dto.SaveMemberCommand;
import com.sa46lll.blogsearcher.dto.SavePostCommand;
import com.sa46lll.blogsearcher.port.in.SaveMemberUseCase;
import com.sa46lll.blogsearcher.port.in.SavePostUseCase;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 애플리케이션이 구동될 때, 초기 데이터를 생성하는 클래스입니다.
 */
@Component
public class DataInitializer implements ApplicationRunner {

    private final SaveMemberUseCase saveMemberUsecase;
    private final SavePostUseCase savePostUsecase;

    public DataInitializer(final SaveMemberUseCase saveMemberUsecase, final SavePostUseCase savePostUsecase) {
        this.saveMemberUsecase = saveMemberUsecase;
        this.savePostUsecase = savePostUsecase;
    }

    @Override
    public void run(ApplicationArguments args) {
        SaveMemberCommand saveMemberCommand = new SaveMemberCommand("member1", "member@example.com");
        SavePostCommand savePostCommand = new SavePostCommand("title1", "content1", 1L);
        SavePostCommand savePostCommand2 = new SavePostCommand("title2", "content2", 1L);
        SavePostCommand savePostCommand3 = new SavePostCommand("title3", "content3", 1L);

        saveMemberUsecase.save(saveMemberCommand);
        savePostUsecase.save(savePostCommand);
        savePostUsecase.save(savePostCommand2);
        savePostUsecase.save(savePostCommand3);
    }
}
