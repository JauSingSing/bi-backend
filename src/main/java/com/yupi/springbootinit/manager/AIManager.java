package com.yupi.springbootinit.manager;

import com.yupi.springbootinit.common.ErrorCode;
import com.yupi.springbootinit.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AIManager {
    @Resource
    private YuCongMingClient AI;

    public String doChat(long modelId, String message) {
        DevChatRequest chatRequest = new DevChatRequest();
        chatRequest.setModelId(modelId);
        chatRequest.setMessage(message);
        BaseResponse<DevChatResponse> response = AI.doChat(chatRequest);
        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI 响应失败");
        }
        return response.getData().getContent();
    }
}
